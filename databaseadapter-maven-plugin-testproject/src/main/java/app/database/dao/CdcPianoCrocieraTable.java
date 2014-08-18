
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
 * Represents {@code DAO} for table {@code CDC_PIANO_CROCIERA}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcPianoCrocieraTable {

	private static final Log LOG = LogFactory.getLog(CdcPianoCrocieraTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_piano_crociera";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_piano_crociera}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_piano_crociera}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_piano_crociera}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_PIANO_CROCIERA}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_PIANO_CROCIERA} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco (da sequence) della tratta di crociera
		 * </p>
		 */
		c_piano_crociera, // data type: 3

		/**
		 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_crociera, // data type: 3

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * Codice dello stato del piano crociera. null indica che il piano crociera e' in attesa di elaborazione
		 * </p>
		 */
		a_stato, // data type: 1

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver, // data type: 3

		/**
		 * Represents column {@code PIANO_MANUALE} of table {@code CDC_PIANO_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		piano_manuale // data type: 12

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcPianoCrocieraTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcPianoCrocieraTable.Record record) {
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

	public void update(CdcPianoCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcPianoCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcPianoCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcPianoCrocieraTable.Column, Object> what, Map<CdcPianoCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcPianoCrocieraTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcPianoCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcPianoCrocieraTable.Record selectFirst(Map<CdcPianoCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcPianoCrocieraTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcPianoCrocieraTable.Record> selectAll(Map<CdcPianoCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcPianoCrocieraTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcPianoCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcPianoCrocieraTable.Column, Object> allMatches, Callback<CdcPianoCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcPianoCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcPianoCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcPianoCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcPianoCrocieraTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcPianoCrocieraTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcPianoCrocieraTable.Column.values().length);
		}

		/* C_PIANO_CROCIERA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCPianoCrociera() { return (java.math.BigDecimal) get(CdcPianoCrocieraTable.Column.c_piano_crociera); }

		public void setCPianoCrociera(java.math.BigDecimal value) { put(CdcPianoCrocieraTable.Column.c_piano_crociera, value); }

		/* C_ENT_BSNS_CROCIERA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsCrociera() { return (java.math.BigDecimal) get(CdcPianoCrocieraTable.Column.c_ent_bsns_crociera); }

		public void setCEntBsnsCrociera(java.math.BigDecimal value) { put(CdcPianoCrocieraTable.Column.c_ent_bsns_crociera, value); }

		/* A_STATO: String (1) */
		public String getAStato() { return (String) get(CdcPianoCrocieraTable.Column.a_stato); }

		public void setAStato(String value) { put(CdcPianoCrocieraTable.Column.a_stato, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcPianoCrocieraTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcPianoCrocieraTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcPianoCrocieraTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcPianoCrocieraTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcPianoCrocieraTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcPianoCrocieraTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcPianoCrocieraTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcPianoCrocieraTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcPianoCrocieraTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcPianoCrocieraTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcPianoCrocieraTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcPianoCrocieraTable.Column.v_ver, value); }

		/* PIANO_MANUALE: String (12) */
		public String getPianoManuale() { return (String) get(CdcPianoCrocieraTable.Column.piano_manuale); }

		public void setPianoManuale(String value) { put(CdcPianoCrocieraTable.Column.piano_manuale, value); }


	}

}