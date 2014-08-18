
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
 * Represents {@code DAO} for table {@code CDC_HMS_APER_ENT_BSNS}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcHmsAperEntBsnsTable {

	private static final Log LOG = LogFactory.getLog(CdcHmsAperEntBsnsTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_hms_aper_ent_bsns";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_hms_aper_ent_bsns}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_hms_aper_ent_bsns}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_hms_aper_ent_bsns}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_HMS_APER_ENT_BSNS}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_ENT_BSNS} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns, // data type: 3

		/**
		 * Represents column {@code C_GIORN_CALEN} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Codice del giorno della settimana cui si applica l'orario. Obbligatorio, può valere 'tutti' se copre l'intera settiamna.
		 * </p>
		 */
		c_giorn_calen, // data type: 3

		/**
		 * Represents column {@code D_INI_VAL} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Inizio del periodo di validita' durante il quale si applica l'orario specificato in questo record
		 * </p>
		 */
		d_ini_val, // data type: 93

		/**
		 * Represents column {@code D_FIN_VAL} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Fine del periodo di validita' durante il quale si applica l'orario specificato in questo record
		 * </p>
		 */
		d_fin_val, // data type: 93

		/**
		 * Represents column {@code H_APER_DA} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Orario di apertura (numerico. Es: 930 per 09:30, 1930 per 19:30)
		 * </p>
		 */
		h_aper_da, // data type: 3

		/**
		 * Represents column {@code H_APER_A} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Orario di chiusura
		 * </p>
		 */
		h_aper_a, // data type: 3

		/**
		 * Represents column {@code F_RICORR_ANN} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Flag di ricorrenza annuale. Se valorizzato a 'S', il periodo di validità dell'orario di apertura si ripete ogni anno.
		 * </p>
		 */
		f_ricorr_ann, // data type: 1

		/**
		 * Represents column {@code X_NOT} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * Eventuali note legate all'orario di apertura
		 * </p>
		 */
		x_not, // data type: 1111

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_HMS_APER_ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_HMS_APER_ENT_BSNS}.
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
	
	public CdcHmsAperEntBsnsTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcHmsAperEntBsnsTable.Record record) {
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

	public void update(CdcHmsAperEntBsnsTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcHmsAperEntBsnsTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcHmsAperEntBsnsTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcHmsAperEntBsnsTable.Column, Object> what, Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcHmsAperEntBsnsTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcHmsAperEntBsnsTable.Record selectFirst(Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcHmsAperEntBsnsTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcHmsAperEntBsnsTable.Record> selectAll(Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcHmsAperEntBsnsTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcHmsAperEntBsnsTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches, Callback<CdcHmsAperEntBsnsTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcHmsAperEntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcHmsAperEntBsnsTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcHmsAperEntBsnsTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcHmsAperEntBsnsTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcHmsAperEntBsnsTable.Column.values().length);
		}

		/* C_ENT_BSNS: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsns() { return (java.math.BigDecimal) get(CdcHmsAperEntBsnsTable.Column.c_ent_bsns); }

		public void setCEntBsns(java.math.BigDecimal value) { put(CdcHmsAperEntBsnsTable.Column.c_ent_bsns, value); }

		/* C_GIORN_CALEN: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCGiornCalen() { return (java.math.BigDecimal) get(CdcHmsAperEntBsnsTable.Column.c_giorn_calen); }

		public void setCGiornCalen(java.math.BigDecimal value) { put(CdcHmsAperEntBsnsTable.Column.c_giorn_calen, value); }

		/* D_INI_VAL: Date (93) */
		public Date getDIniVal() { return (Date) get(CdcHmsAperEntBsnsTable.Column.d_ini_val); }

		public void setDIniVal(Date value) { put(CdcHmsAperEntBsnsTable.Column.d_ini_val, value); }

		/* D_FIN_VAL: Date (93) */
		public Date getDFinVal() { return (Date) get(CdcHmsAperEntBsnsTable.Column.d_fin_val); }

		public void setDFinVal(Date value) { put(CdcHmsAperEntBsnsTable.Column.d_fin_val, value); }

		/* H_APER_DA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getHAperDa() { return (java.math.BigDecimal) get(CdcHmsAperEntBsnsTable.Column.h_aper_da); }

		public void setHAperDa(java.math.BigDecimal value) { put(CdcHmsAperEntBsnsTable.Column.h_aper_da, value); }

		/* H_APER_A: java.math.BigDecimal (3) */
		public java.math.BigDecimal getHAperA() { return (java.math.BigDecimal) get(CdcHmsAperEntBsnsTable.Column.h_aper_a); }

		public void setHAperA(java.math.BigDecimal value) { put(CdcHmsAperEntBsnsTable.Column.h_aper_a, value); }

		/* F_RICORR_ANN: String (1) */
		public String getFRicorrAnn() { return (String) get(CdcHmsAperEntBsnsTable.Column.f_ricorr_ann); }

		public void setFRicorrAnn(String value) { put(CdcHmsAperEntBsnsTable.Column.f_ricorr_ann, value); }

		/* X_NOT: String (1111) */
		public String getXNot() { return (String) get(CdcHmsAperEntBsnsTable.Column.x_not); }

		public void setXNot(String value) { put(CdcHmsAperEntBsnsTable.Column.x_not, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcHmsAperEntBsnsTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcHmsAperEntBsnsTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcHmsAperEntBsnsTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcHmsAperEntBsnsTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcHmsAperEntBsnsTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcHmsAperEntBsnsTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcHmsAperEntBsnsTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcHmsAperEntBsnsTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcHmsAperEntBsnsTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcHmsAperEntBsnsTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcHmsAperEntBsnsTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcHmsAperEntBsnsTable.Column.v_ver, value); }


	}

}