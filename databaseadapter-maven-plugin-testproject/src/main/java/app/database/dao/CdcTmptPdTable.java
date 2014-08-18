
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
 * Represents {@code DAO} for table {@code CDC_TMPT_PD}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcTmptPdTable {

	private static final Log LOG = LogFactory.getLog(CdcTmptPdTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_tmpt_pd";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tmpt_pd}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_tmpt_pd}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_tmpt_pd}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_TMPT_PD}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_TMPT_PD} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * Codice interno del Periodo
		 * </p>
		 */
		c_tmpt_pd, // data type: 3

		/**
		 * Represents column {@code D_VAL_PD_DA} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * Data inizio del Periodo
		 * </p>
		 */
		d_val_pd_da, // data type: 93

		/**
		 * Represents column {@code D_VAL_PD_A} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * Data fine del Periodo
		 * </p>
		 */
		d_val_pd_a, // data type: 93

		/**
		 * Represents column {@code N_TMPT_PD} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * Nome del periodo
		 * </p>
		 */
		n_tmpt_pd, // data type: 1111

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_TMPT_PD}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver // data type: 3

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcTmptPdTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcTmptPdTable.Record record) {
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

	public void update(CdcTmptPdTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcTmptPdTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcTmptPdTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcTmptPdTable.Column, Object> what, Map<CdcTmptPdTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcTmptPdTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcTmptPdTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcTmptPdTable.Record selectFirst(Map<CdcTmptPdTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcTmptPdTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcTmptPdTable.Record> selectAll(Map<CdcTmptPdTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcTmptPdTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcTmptPdTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcTmptPdTable.Column, Object> allMatches, Callback<CdcTmptPdTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcTmptPdTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcTmptPdTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TMPT_PD}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTmptPdTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TMPT_PD}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTmptPdTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcTmptPdTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcTmptPdTable.Column.values().length);
		}

		/* C_TMPT_PD: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTmptPd() { return (java.math.BigDecimal) get(CdcTmptPdTable.Column.c_tmpt_pd); }

		public void setCTmptPd(java.math.BigDecimal value) { put(CdcTmptPdTable.Column.c_tmpt_pd, value); }

		/* D_VAL_PD_DA: Date (93) */
		public Date getDValPdDa() { return (Date) get(CdcTmptPdTable.Column.d_val_pd_da); }

		public void setDValPdDa(Date value) { put(CdcTmptPdTable.Column.d_val_pd_da, value); }

		/* D_VAL_PD_A: Date (93) */
		public Date getDValPdA() { return (Date) get(CdcTmptPdTable.Column.d_val_pd_a); }

		public void setDValPdA(Date value) { put(CdcTmptPdTable.Column.d_val_pd_a, value); }

		/* N_TMPT_PD: String (1111) */
		public String getNTmptPd() { return (String) get(CdcTmptPdTable.Column.n_tmpt_pd); }

		public void setNTmptPd(String value) { put(CdcTmptPdTable.Column.n_tmpt_pd, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcTmptPdTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcTmptPdTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcTmptPdTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcTmptPdTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcTmptPdTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcTmptPdTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcTmptPdTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcTmptPdTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcTmptPdTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcTmptPdTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcTmptPdTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcTmptPdTable.Column.v_ver, value); }


	}

}