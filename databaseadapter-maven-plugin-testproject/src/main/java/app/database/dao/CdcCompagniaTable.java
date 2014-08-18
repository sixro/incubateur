
package app.database.dao;

import java.util.*;

import javax.annotation.Generated;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


/**
 * Represents {@code DAO} for table {@code CDC_COMPAGNIA}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCompagniaTable {

	private static final Log LOG = LogFactory.getLog(CdcCompagniaTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_compagnia";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_compagnia}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_compagnia}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_compagnia}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_COMPAGNIA}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_COMPAGNIA} of table {@code CDC_COMPAGNIA}.
		 *
		 * <p>
		 * Codice Costa della compagnia
		 * </p>
		 */
		c_compagnia, // data type: 12

		/**
		 * Represents column {@code N_COMPAGNIA} of table {@code CDC_COMPAGNIA}.
		 *
		 * <p>
		 * Nome della compagnia
		 * </p>
		 */
		n_compagnia, // data type: 12

		/**
		 * Represents column {@code DWH_COMPANY_CODE} of table {@code CDC_COMPAGNIA}.
		 *
		 * <p>
		 * Codice univoco compagnia nel DWH
		 * </p>
		 */
		dwh_company_code // data type: 12

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcCompagniaTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcCompagniaTable.Record record) {
		LOG.info("inserting record " + record + "...");
		
		Column[] columns = record.keySet().toArray(new Column[]{ });
		String sql = new StringBuilder("INSERT INTO ")
			.append(TABLE)
			.append(" (")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(") VALUES (")
			.append(StringUtils.join(namesOf(columns, ":${name}"), ", "))
			.append(")")
			.toString();
		LOG.debug("... generated SQL: '" + sql);
			
		Map<String, Object> paramMap = new HashMap<String, Object>(columns.length);
		for (Map.Entry<Column, Object> entry : record.entrySet())
			paramMap.put(entry.getKey().name(), entry.getValue());
		
		LOG.debug("... executing statement with parameters: " + paramMap);
		
		int affected = namedJdbcTemplate.update(sql, paramMap);
		if (affected == 0)
			throw new IllegalStateException("execution of a SQL of insert has affected " + affected + " rows?!?");
		
		LOG.info("... insert of record " + record + " done");
	}

	public void update(CdcCompagniaTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcCompagniaTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcCompagniaTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCompagniaTable.Column, Object> what, Map<CdcCompagniaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCompagniaTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcCompagniaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcCompagniaTable.Record selectFirst(Map<CdcCompagniaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcCompagniaTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCompagniaTable.Record> selectAll(Map<CdcCompagniaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCompagniaTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcCompagniaTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcCompagniaTable.Column, Object> allMatches, Callback<CdcCompagniaTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcCompagniaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcCompagniaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCompagniaTable.Column[] columns) {
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) cols[i] = columns[i].name();
		return cols;
	}

	/**
	 * Returns the names of specified columns applying specified template.
	 * 
	 * <p>
	 * The template has to contain placeholder {@code name} to represent the column name. E.g.
	 * </p>
	 * <pre>
	 *     ${name} = ?
	 * </pre>
	 *
	 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCompagniaTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcCompagniaTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcCompagniaTable.Column.values().length);
		}

		/* C_COMPAGNIA: String (12) */
		public String getCCompagnia() { return (String) get(CdcCompagniaTable.Column.c_compagnia); }

		public void setCCompagnia(String value) { put(CdcCompagniaTable.Column.c_compagnia, value); }

		/* N_COMPAGNIA: String (12) */
		public String getNCompagnia() { return (String) get(CdcCompagniaTable.Column.n_compagnia); }

		public void setNCompagnia(String value) { put(CdcCompagniaTable.Column.n_compagnia, value); }

		/* DWH_COMPANY_CODE: String (12) */
		public String getDwhCompanyCode() { return (String) get(CdcCompagniaTable.Column.dwh_company_code); }

		public void setDwhCompanyCode(String value) { put(CdcCompagniaTable.Column.dwh_company_code, value); }


	}

}