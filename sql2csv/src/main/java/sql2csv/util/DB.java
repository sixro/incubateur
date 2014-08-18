package sql2csv.util;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DB {

	private final NamedParameterJdbcTemplate jdbc;

	public DB(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public void query(String sql, Map<String, Object> parameters, final RowListener rowListener) {
		jdbc.query(sql, parameters, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map<String, Object> row = toRow(rs);
                rowListener.onRow(row);
				return null;
			}
		});
	}

	public void execute(String sql) {
		jdbc.getJdbcOperations().execute(sql);
	}

    public static interface RowListener {

        public void onRow(Map<String, Object> row);

    }

    public static Map<String, Object> toRow(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        LinkedHashMap<String, Object> record = new LinkedHashMap<String, Object>();
        for (int column = 1; column <= columnCount; column++) {
            record.put(metaData.getColumnName(column), rs.getObject(column));
        }
        return record;
    }

}
