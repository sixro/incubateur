package burgeonapp;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

@Component
public class DB {

	private static final Logger LOG = LoggerFactory.getLogger(DB.class);

	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public DB(DataSource dataSource, NamedParameterJdbcTemplate jdbcTemplate) {
		super();
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<String> findTableNames(String[] includePatterns, String[] excludePatterns) {
		List<String> results = new LinkedList<>();
		List<Map<String, Object>> tables = findTables("%", "%", "%", null);
		for (Map<String, Object> table : tables) {
			String tableName = (String) table.get("TABLE_NAME");
			if (includePatterns != null) {
				boolean match = false;
				for (String includePattern : includePatterns) {
					if (tableName.matches(includePattern)) {
						match = true;
						break;
					}
				}

				if (!match)
					continue;
			}

			if (excludePatterns != null) {
				for (String excludePattern : excludePatterns)
					if (tableName.matches(excludePattern))
						continue;
			}

			results.add(tableName.toLowerCase());
		}
		return results;
	}

	public List<Map<String, Object>> findTables(String catalogPattern, String schemePattern, String tablesPattern,
			String[] tableTypes) {
		Connection conn = null;
		ResultSet rsTables = null;
		try {
			conn = DataSourceUtils.getConnection(dataSource);
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			LOG.info("{} {}", databaseMetaData.getDatabaseProductName(), databaseMetaData.getDatabaseProductVersion());
			rsTables = databaseMetaData.getTables(catalogPattern, schemePattern, tablesPattern, null);
			LinkedList<Map<String, Object>> data = new LinkedList<>();
			while (rsTables.next()) {
				ResultSetMetaData resultSetMetaData = rsTables.getMetaData();
				int columnCount = resultSetMetaData.getColumnCount();
				Map<String, Object> datum = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = resultSetMetaData.getColumnName(i);
					Object columnValue = rsTables.getObject(columnName);
					LOG.debug("... column {} valued as {}...", columnName, columnValue);
					if (columnValue != null)
						datum.put(columnName, columnValue);
				}
				LOG.info("... adding {}", datum);
				data.add(datum);
			}

			return data;
		} catch (Exception e) {
			LOG.error("Unable to find tables in datasource {} due to a {} with message '{}'", dataSource,
					e.getClass().getName(), e.getMessage(), e);
			throw new RuntimeException("Unable to find tables in datasource " + dataSource, e);
		} finally {
			JdbcUtils.closeResultSet(rsTables);
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}

	@SuppressWarnings("unchecked")
	public PageData loadPageData(String sql, String pagingSqlSnippet, int pageNumber, int pageSize) {
		LOG.info("loading page {} (of size {}) using sql '{}' and paging snippet '{}' ...", pageNumber, pageSize, sql, pagingSqlSnippet);
		
		Map<String, Integer> params = new HashMap<>();
		params.put("pageNumber", pageNumber);
		params.put("pageSize", pageSize);
		PageData pageData = jdbcTemplate.query(sql + " " + pagingSqlSnippet, params, new ResultSetExtractor<PageData>() {

			@Override
			public PageData extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData metadata = rs.getMetaData();
				
				LinkedList<Map<String, Object>> data = new LinkedList<>();
				while (rs.next()) {
					int columnCount = metadata.getColumnCount();
					Map<String, Object> datum = new LinkedHashMap<>();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metadata.getColumnName(i);
						Object columnValue = rs.getObject(columnName);
						LOG.debug("... column {} valued as {}...", columnName, columnValue);
						if (columnValue != null)
							datum.put(columnName, columnValue);
					}
					LOG.info("... adding {}", datum);
					data.add(datum);
				}

				return new PageData(data);
			}
		});
		
		pageData.addMeta("page-number", pageNumber);
		pageData.addMeta("page-size", pageSize);
		Integer totalRows = jdbcTemplate.queryForObject("select count(*) from (" + sql + ")", Collections.EMPTY_MAP, Integer.class);
		pageData.addMeta("total-rows", totalRows);
		int pages = totalRows / pageSize;
		if (totalRows % pageSize != 0) pages++;
		pageData.addMeta("pages", pages);
		
		return pageData;
	}
	
}
