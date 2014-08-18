
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
 * Represents {@code DAO} for table {@code CDC_TRATTA_CROCIERA}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcTrattaCrocieraTable {

	private static final Log LOG = LogFactory.getLog(CdcTrattaCrocieraTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_tratta_crociera";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tratta_crociera}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_tratta_crociera}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_tratta_crociera}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_TRATTA_CROCIERA}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_TRATTA_CROCIERA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tratta_crociera, // data type: 3

		/**
		 * Represents column {@code D_INI_TRATTA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Data e orario di inizio tratta
		 * </p>
		 */
		d_ini_tratta, // data type: 93

		/**
		 * Represents column {@code D_FIN_TRATTA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Data e orario di fine tratta
		 * </p>
		 */
		d_fin_tratta, // data type: 93

		/**
		 * Represents column {@code C_PIANO_CROCIERA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco (da sequence) della tratta di crociera
		 * </p>
		 */
		c_piano_crociera, // data type: 3

		/**
		 * Represents column {@code C_TIP_TRATTA_CROCIERA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Codice del tipo di Stato di attraversamento di una determinata tratta del piano di Crociera.
Valori ammissibili:
  'P' - Partenza (inizio Crociera)
  'N' - Navigazione
  'S' - Scalo
  'D' - Arrivo (termine Crociera)
  'A' - Attracco
  'T' - Transito
		 * </p>
		 */
		c_tip_tratta_crociera, // data type: 12

		/**
		 * Represents column {@code C_ENT_BSNS_PORTO} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Codice del Porto corrispondente alla tratta
		 * </p>
		 */
		c_ent_bsns_porto, // data type: 3

		/**
		 * Represents column {@code F_RADA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_rada, // data type: 1

		/**
		 * Represents column {@code F_RIFORNIMENTO} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_rifornimento, // data type: 1

		/**
		 * Represents column {@code F_NASCONDI_INTRANET} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_nascondi_intranet, // data type: 1

		/**
		 * Represents column {@code X_NOT} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Note libere sulla tratta
		 * </p>
		 */
		x_not, // data type: 1111

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_TRATTA_CROCIERA}.
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
	
	public CdcTrattaCrocieraTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcTrattaCrocieraTable.Record record) {
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

	public void update(CdcTrattaCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcTrattaCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcTrattaCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcTrattaCrocieraTable.Column, Object> what, Map<CdcTrattaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcTrattaCrocieraTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcTrattaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcTrattaCrocieraTable.Record selectFirst(Map<CdcTrattaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcTrattaCrocieraTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcTrattaCrocieraTable.Record> selectAll(Map<CdcTrattaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcTrattaCrocieraTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcTrattaCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcTrattaCrocieraTable.Column, Object> allMatches, Callback<CdcTrattaCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcTrattaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcTrattaCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTrattaCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTrattaCrocieraTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcTrattaCrocieraTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcTrattaCrocieraTable.Column.values().length);
		}

		/* C_TRATTA_CROCIERA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTrattaCrociera() { return (java.math.BigDecimal) get(CdcTrattaCrocieraTable.Column.c_tratta_crociera); }

		public void setCTrattaCrociera(java.math.BigDecimal value) { put(CdcTrattaCrocieraTable.Column.c_tratta_crociera, value); }

		/* D_INI_TRATTA: Date (93) */
		public Date getDIniTratta() { return (Date) get(CdcTrattaCrocieraTable.Column.d_ini_tratta); }

		public void setDIniTratta(Date value) { put(CdcTrattaCrocieraTable.Column.d_ini_tratta, value); }

		/* D_FIN_TRATTA: Date (93) */
		public Date getDFinTratta() { return (Date) get(CdcTrattaCrocieraTable.Column.d_fin_tratta); }

		public void setDFinTratta(Date value) { put(CdcTrattaCrocieraTable.Column.d_fin_tratta, value); }

		/* C_PIANO_CROCIERA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCPianoCrociera() { return (java.math.BigDecimal) get(CdcTrattaCrocieraTable.Column.c_piano_crociera); }

		public void setCPianoCrociera(java.math.BigDecimal value) { put(CdcTrattaCrocieraTable.Column.c_piano_crociera, value); }

		/* C_TIP_TRATTA_CROCIERA: String (12) */
		public String getCTipTrattaCrociera() { return (String) get(CdcTrattaCrocieraTable.Column.c_tip_tratta_crociera); }

		public void setCTipTrattaCrociera(String value) { put(CdcTrattaCrocieraTable.Column.c_tip_tratta_crociera, value); }

		/* C_ENT_BSNS_PORTO: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsPorto() { return (java.math.BigDecimal) get(CdcTrattaCrocieraTable.Column.c_ent_bsns_porto); }

		public void setCEntBsnsPorto(java.math.BigDecimal value) { put(CdcTrattaCrocieraTable.Column.c_ent_bsns_porto, value); }

		/* F_RADA: String (1) */
		public String getFRada() { return (String) get(CdcTrattaCrocieraTable.Column.f_rada); }

		public void setFRada(String value) { put(CdcTrattaCrocieraTable.Column.f_rada, value); }

		/* F_RIFORNIMENTO: String (1) */
		public String getFRifornimento() { return (String) get(CdcTrattaCrocieraTable.Column.f_rifornimento); }

		public void setFRifornimento(String value) { put(CdcTrattaCrocieraTable.Column.f_rifornimento, value); }

		/* F_NASCONDI_INTRANET: String (1) */
		public String getFNascondiIntranet() { return (String) get(CdcTrattaCrocieraTable.Column.f_nascondi_intranet); }

		public void setFNascondiIntranet(String value) { put(CdcTrattaCrocieraTable.Column.f_nascondi_intranet, value); }

		/* X_NOT: String (1111) */
		public String getXNot() { return (String) get(CdcTrattaCrocieraTable.Column.x_not); }

		public void setXNot(String value) { put(CdcTrattaCrocieraTable.Column.x_not, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcTrattaCrocieraTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcTrattaCrocieraTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcTrattaCrocieraTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcTrattaCrocieraTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcTrattaCrocieraTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcTrattaCrocieraTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcTrattaCrocieraTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcTrattaCrocieraTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcTrattaCrocieraTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcTrattaCrocieraTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcTrattaCrocieraTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcTrattaCrocieraTable.Column.v_ver, value); }


	}

}