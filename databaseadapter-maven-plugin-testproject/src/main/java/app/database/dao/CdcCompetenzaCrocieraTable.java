
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
 * Represents {@code DAO} for table {@code CDC_COMPETENZA_CROCIERA}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCompetenzaCrocieraTable {

	private static final Log LOG = LogFactory.getLog(CdcCompetenzaCrocieraTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_competenza_crociera";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_competenza_crociera}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_competenza_crociera}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_competenza_crociera}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_COMPETENZA_CROCIERA}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code D_MESE_CPTN} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * Mese di competenza all'interno dell'anno fiscale
		 * </p>
		 */
		d_mese_cptn, // data type: 12

		/**
		 * Represents column {@code D_MESE_COMLE} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * Mese di competenza commerciale all'interno dell'anno fiscale
		 * </p>
		 */
		d_mese_comle, // data type: 12

		/**
		 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_crociera, // data type: 3

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_COMPETENZA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_COMPETENZA_CROCIERA}.
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
	
	public CdcCompetenzaCrocieraTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcCompetenzaCrocieraTable.Record record) {
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

	public void update(CdcCompetenzaCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcCompetenzaCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcCompetenzaCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCompetenzaCrocieraTable.Column, Object> what, Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCompetenzaCrocieraTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcCompetenzaCrocieraTable.Record selectFirst(Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcCompetenzaCrocieraTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCompetenzaCrocieraTable.Record> selectAll(Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCompetenzaCrocieraTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcCompetenzaCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches, Callback<CdcCompetenzaCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcCompetenzaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCompetenzaCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCompetenzaCrocieraTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcCompetenzaCrocieraTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcCompetenzaCrocieraTable.Column.values().length);
		}

		/* D_MESE_CPTN: String (12) */
		public String getDMeseCptn() { return (String) get(CdcCompetenzaCrocieraTable.Column.d_mese_cptn); }

		public void setDMeseCptn(String value) { put(CdcCompetenzaCrocieraTable.Column.d_mese_cptn, value); }

		/* D_MESE_COMLE: String (12) */
		public String getDMeseComle() { return (String) get(CdcCompetenzaCrocieraTable.Column.d_mese_comle); }

		public void setDMeseComle(String value) { put(CdcCompetenzaCrocieraTable.Column.d_mese_comle, value); }

		/* C_ENT_BSNS_CROCIERA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsCrociera() { return (java.math.BigDecimal) get(CdcCompetenzaCrocieraTable.Column.c_ent_bsns_crociera); }

		public void setCEntBsnsCrociera(java.math.BigDecimal value) { put(CdcCompetenzaCrocieraTable.Column.c_ent_bsns_crociera, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcCompetenzaCrocieraTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcCompetenzaCrocieraTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcCompetenzaCrocieraTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcCompetenzaCrocieraTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcCompetenzaCrocieraTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcCompetenzaCrocieraTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcCompetenzaCrocieraTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcCompetenzaCrocieraTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcCompetenzaCrocieraTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcCompetenzaCrocieraTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcCompetenzaCrocieraTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcCompetenzaCrocieraTable.Column.v_ver, value); }


	}

}