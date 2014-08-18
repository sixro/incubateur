
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
 * Represents {@code DAO} for table {@code CDC_FSTVT}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcFstvtTable {

	private static final Log LOG = LogFactory.getLog(CdcFstvtTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_fstvt";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_fstvt}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_fstvt}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_fstvt}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_FSTVT}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_FSTVT} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * Codice Festività
		 * </p>
		 */
		c_fstvt, // data type: 3

		/**
		 * Represents column {@code N_FSTVT} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * Nome della Festivita
		 * </p>
		 */
		n_fstvt, // data type: 1111

		/**
		 * Represents column {@code C_TIP_FSTVT} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tip_fstvt, // data type: 3

		/**
		 * Represents column {@code F_RICORR} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * Flag che indica se la festività si ripete nello stesso giorno ogni anno.
		 * </p>
		 */
		f_ricorr, // data type: 1

		/**
		 * Represents column {@code D_FIN_FSTVT} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * Fine del periodo di festività. Può essere nullo se la festività è un giorno singolo.
		 * </p>
		 */
		d_fin_fstvt, // data type: 93

		/**
		 * Represents column {@code D_INI_FSTVT} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * Inizio del periodo di festività
		 * </p>
		 */
		d_ini_fstvt, // data type: 93

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_FSTVT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_FSTVT}.
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
	
	public CdcFstvtTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcFstvtTable.Record record) {
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

	public void update(CdcFstvtTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcFstvtTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcFstvtTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcFstvtTable.Column, Object> what, Map<CdcFstvtTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcFstvtTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcFstvtTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcFstvtTable.Record selectFirst(Map<CdcFstvtTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcFstvtTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcFstvtTable.Record> selectAll(Map<CdcFstvtTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcFstvtTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcFstvtTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcFstvtTable.Column, Object> allMatches, Callback<CdcFstvtTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcFstvtTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcFstvtTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_FSTVT}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcFstvtTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_FSTVT}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcFstvtTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcFstvtTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcFstvtTable.Column.values().length);
		}

		/* C_FSTVT: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCFstvt() { return (java.math.BigDecimal) get(CdcFstvtTable.Column.c_fstvt); }

		public void setCFstvt(java.math.BigDecimal value) { put(CdcFstvtTable.Column.c_fstvt, value); }

		/* N_FSTVT: String (1111) */
		public String getNFstvt() { return (String) get(CdcFstvtTable.Column.n_fstvt); }

		public void setNFstvt(String value) { put(CdcFstvtTable.Column.n_fstvt, value); }

		/* C_TIP_FSTVT: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTipFstvt() { return (java.math.BigDecimal) get(CdcFstvtTable.Column.c_tip_fstvt); }

		public void setCTipFstvt(java.math.BigDecimal value) { put(CdcFstvtTable.Column.c_tip_fstvt, value); }

		/* F_RICORR: String (1) */
		public String getFRicorr() { return (String) get(CdcFstvtTable.Column.f_ricorr); }

		public void setFRicorr(String value) { put(CdcFstvtTable.Column.f_ricorr, value); }

		/* D_FIN_FSTVT: Date (93) */
		public Date getDFinFstvt() { return (Date) get(CdcFstvtTable.Column.d_fin_fstvt); }

		public void setDFinFstvt(Date value) { put(CdcFstvtTable.Column.d_fin_fstvt, value); }

		/* D_INI_FSTVT: Date (93) */
		public Date getDIniFstvt() { return (Date) get(CdcFstvtTable.Column.d_ini_fstvt); }

		public void setDIniFstvt(Date value) { put(CdcFstvtTable.Column.d_ini_fstvt, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcFstvtTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcFstvtTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcFstvtTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcFstvtTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcFstvtTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcFstvtTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcFstvtTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcFstvtTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcFstvtTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcFstvtTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcFstvtTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcFstvtTable.Column.v_ver, value); }


	}

}