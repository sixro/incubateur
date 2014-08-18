
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
 * Represents {@code DAO} for table {@code CDC_PORTO}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcPortoTable {

	private static final Log LOG = LogFactory.getLog(CdcPortoTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_porto";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_porto}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_porto}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_porto}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_PORTO}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code G_PORTO} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * Codifica Costa del porto
		 * </p>
		 */
		g_porto, // data type: 12

		/**
		 * Represents column {@code N_PORTO} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_porto, // data type: 1111

		/**
		 * Represents column {@code S_PORTO} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		s_porto, // data type: 1111

		/**
		 * Represents column {@code C_ENT_BSNS_PORTO} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_porto, // data type: 3

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato, // data type: 1

		/**
		 * Represents column {@code F_NASCONDI_INTRANET} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_nascondi_intranet, // data type: 1

		/**
		 * Represents column {@code C_ENT_BSNS_AREA_GEOGR_AREA} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_area_geogr_area, // data type: 3

		/**
		 * Represents column {@code C_ENT_BSNS_AREA_GEOGR_PAESE} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_area_geogr_paese, // data type: 3

		/**
		 * Represents column {@code C_ENT_BSNS_AREA_GEOGR_CITTA} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_area_geogr_citta, // data type: 3

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver, // data type: 3

		/**
		 * Represents column {@code UN_LOCATION_CODE} of table {@code CDC_PORTO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		un_location_code // data type: 12

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcPortoTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcPortoTable.Record record) {
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

	public void update(CdcPortoTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcPortoTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcPortoTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcPortoTable.Column, Object> what, Map<CdcPortoTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcPortoTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcPortoTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcPortoTable.Record selectFirst(Map<CdcPortoTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcPortoTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcPortoTable.Record> selectAll(Map<CdcPortoTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcPortoTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcPortoTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcPortoTable.Column, Object> allMatches, Callback<CdcPortoTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcPortoTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcPortoTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_PORTO}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcPortoTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_PORTO}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcPortoTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcPortoTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcPortoTable.Column.values().length);
		}

		/* G_PORTO: String (12) */
		public String getGPorto() { return (String) get(CdcPortoTable.Column.g_porto); }

		public void setGPorto(String value) { put(CdcPortoTable.Column.g_porto, value); }

		/* N_PORTO: String (1111) */
		public String getNPorto() { return (String) get(CdcPortoTable.Column.n_porto); }

		public void setNPorto(String value) { put(CdcPortoTable.Column.n_porto, value); }

		/* S_PORTO: String (1111) */
		public String getSPorto() { return (String) get(CdcPortoTable.Column.s_porto); }

		public void setSPorto(String value) { put(CdcPortoTable.Column.s_porto, value); }

		/* C_ENT_BSNS_PORTO: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsPorto() { return (java.math.BigDecimal) get(CdcPortoTable.Column.c_ent_bsns_porto); }

		public void setCEntBsnsPorto(java.math.BigDecimal value) { put(CdcPortoTable.Column.c_ent_bsns_porto, value); }

		/* A_STATO: String (1) */
		public String getAStato() { return (String) get(CdcPortoTable.Column.a_stato); }

		public void setAStato(String value) { put(CdcPortoTable.Column.a_stato, value); }

		/* F_NASCONDI_INTRANET: String (1) */
		public String getFNascondiIntranet() { return (String) get(CdcPortoTable.Column.f_nascondi_intranet); }

		public void setFNascondiIntranet(String value) { put(CdcPortoTable.Column.f_nascondi_intranet, value); }

		/* C_ENT_BSNS_AREA_GEOGR_AREA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsAreaGeogrArea() { return (java.math.BigDecimal) get(CdcPortoTable.Column.c_ent_bsns_area_geogr_area); }

		public void setCEntBsnsAreaGeogrArea(java.math.BigDecimal value) { put(CdcPortoTable.Column.c_ent_bsns_area_geogr_area, value); }

		/* C_ENT_BSNS_AREA_GEOGR_PAESE: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsAreaGeogrPaese() { return (java.math.BigDecimal) get(CdcPortoTable.Column.c_ent_bsns_area_geogr_paese); }

		public void setCEntBsnsAreaGeogrPaese(java.math.BigDecimal value) { put(CdcPortoTable.Column.c_ent_bsns_area_geogr_paese, value); }

		/* C_ENT_BSNS_AREA_GEOGR_CITTA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsAreaGeogrCitta() { return (java.math.BigDecimal) get(CdcPortoTable.Column.c_ent_bsns_area_geogr_citta); }

		public void setCEntBsnsAreaGeogrCitta(java.math.BigDecimal value) { put(CdcPortoTable.Column.c_ent_bsns_area_geogr_citta, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcPortoTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcPortoTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcPortoTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcPortoTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcPortoTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcPortoTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcPortoTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcPortoTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcPortoTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcPortoTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcPortoTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcPortoTable.Column.v_ver, value); }

		/* UN_LOCATION_CODE: String (12) */
		public String getUnLocationCode() { return (String) get(CdcPortoTable.Column.un_location_code); }

		public void setUnLocationCode(String value) { put(CdcPortoTable.Column.un_location_code, value); }


	}

}