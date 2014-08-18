
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
 * Represents {@code DAO} for table {@code CDC_CROCIERA}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCrocieraTable {

	private static final Log LOG = LogFactory.getLog(CdcCrocieraTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_crociera";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_crociera}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_crociera}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_crociera}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_CROCIERA}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_CROCIERA_COSTA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice Crociera. Composto sempre da 6 caratteri cosi' ripartiti:
        <NN><CC><AAAA>
dove:
NN: Codice Nave Costa (CDC_NAVE.C_NAVE)
CC: Numero progressivo Crociera per la Nave, sempre di 2 char
AAAA: Anno della crociera
		 * </p>
		 */
		c_crociera_costa, // data type: 12

		/**
		 * Represents column {@code D_INI_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Data di inizio Crociera
		 * </p>
		 */
		d_ini_crociera, // data type: 93

		/**
		 * Represents column {@code D_FIN_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Data di Fine Crociera
		 * </p>
		 */
		d_fin_crociera, // data type: 93

		/**
		 * Represents column {@code V_DURATA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Durata della Crociera in giorni
		 * </p>
		 */
		v_durata, // data type: 3

		/**
		 * Represents column {@code S_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Descrizione Crociera
		 * </p>
		 */
		s_crociera, // data type: 1111

		/**
		 * Represents column {@code N_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Nome (Descrizione breve) della Crociera
		 * </p>
		 */
		n_crociera, // data type: 1111

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato, // data type: 1

		/**
		 * Represents column {@code C_DEPLOYMENT} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice interno del deployment (da sequence)
		 * </p>
		 */
		c_deployment, // data type: 3

		/**
		 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_crociera, // data type: 3

		/**
		 * Represents column {@code C_TIP_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice tipo crociera
		 * </p>
		 */
		c_tip_crociera, // data type: 12

		/**
		 * Represents column {@code F_NASCONDI_INTRANET} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_nascondi_intranet, // data type: 1

		/**
		 * Represents column {@code N_STAGIONE} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_stagione, // data type: 1111

		/**
		 * Represents column {@code C_ENT_BSNS_NAVE} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_nave, // data type: 3

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver, // data type: 3

		/**
		 * Represents column {@code F_BLOCCO_INS_PENALE} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Flag che regola l'inserimento delle penali: se Y sono inseribili solo a fine crociera
		 * </p>
		 */
		f_blocco_ins_penale // data type: 12

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcCrocieraTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcCrocieraTable.Record record) {
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

	public void update(CdcCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcCrocieraTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCrocieraTable.Column, Object> what, Map<CdcCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCrocieraTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcCrocieraTable.Record selectFirst(Map<CdcCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcCrocieraTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCrocieraTable.Record> selectAll(Map<CdcCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCrocieraTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcCrocieraTable.Column, Object> allMatches, Callback<CdcCrocieraTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcCrocieraTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCrocieraTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcCrocieraTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcCrocieraTable.Column.values().length);
		}

		/* C_CROCIERA_COSTA: String (12) */
		public String getCCrocieraCosta() { return (String) get(CdcCrocieraTable.Column.c_crociera_costa); }

		public void setCCrocieraCosta(String value) { put(CdcCrocieraTable.Column.c_crociera_costa, value); }

		/* D_INI_CROCIERA: Date (93) */
		public Date getDIniCrociera() { return (Date) get(CdcCrocieraTable.Column.d_ini_crociera); }

		public void setDIniCrociera(Date value) { put(CdcCrocieraTable.Column.d_ini_crociera, value); }

		/* D_FIN_CROCIERA: Date (93) */
		public Date getDFinCrociera() { return (Date) get(CdcCrocieraTable.Column.d_fin_crociera); }

		public void setDFinCrociera(Date value) { put(CdcCrocieraTable.Column.d_fin_crociera, value); }

		/* V_DURATA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVDurata() { return (java.math.BigDecimal) get(CdcCrocieraTable.Column.v_durata); }

		public void setVDurata(java.math.BigDecimal value) { put(CdcCrocieraTable.Column.v_durata, value); }

		/* S_CROCIERA: String (1111) */
		public String getSCrociera() { return (String) get(CdcCrocieraTable.Column.s_crociera); }

		public void setSCrociera(String value) { put(CdcCrocieraTable.Column.s_crociera, value); }

		/* N_CROCIERA: String (1111) */
		public String getNCrociera() { return (String) get(CdcCrocieraTable.Column.n_crociera); }

		public void setNCrociera(String value) { put(CdcCrocieraTable.Column.n_crociera, value); }

		/* A_STATO: String (1) */
		public String getAStato() { return (String) get(CdcCrocieraTable.Column.a_stato); }

		public void setAStato(String value) { put(CdcCrocieraTable.Column.a_stato, value); }

		/* C_DEPLOYMENT: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCDeployment() { return (java.math.BigDecimal) get(CdcCrocieraTable.Column.c_deployment); }

		public void setCDeployment(java.math.BigDecimal value) { put(CdcCrocieraTable.Column.c_deployment, value); }

		/* C_ENT_BSNS_CROCIERA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsCrociera() { return (java.math.BigDecimal) get(CdcCrocieraTable.Column.c_ent_bsns_crociera); }

		public void setCEntBsnsCrociera(java.math.BigDecimal value) { put(CdcCrocieraTable.Column.c_ent_bsns_crociera, value); }

		/* C_TIP_CROCIERA: String (12) */
		public String getCTipCrociera() { return (String) get(CdcCrocieraTable.Column.c_tip_crociera); }

		public void setCTipCrociera(String value) { put(CdcCrocieraTable.Column.c_tip_crociera, value); }

		/* F_NASCONDI_INTRANET: String (1) */
		public String getFNascondiIntranet() { return (String) get(CdcCrocieraTable.Column.f_nascondi_intranet); }

		public void setFNascondiIntranet(String value) { put(CdcCrocieraTable.Column.f_nascondi_intranet, value); }

		/* N_STAGIONE: String (1111) */
		public String getNStagione() { return (String) get(CdcCrocieraTable.Column.n_stagione); }

		public void setNStagione(String value) { put(CdcCrocieraTable.Column.n_stagione, value); }

		/* C_ENT_BSNS_NAVE: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsNave() { return (java.math.BigDecimal) get(CdcCrocieraTable.Column.c_ent_bsns_nave); }

		public void setCEntBsnsNave(java.math.BigDecimal value) { put(CdcCrocieraTable.Column.c_ent_bsns_nave, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcCrocieraTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcCrocieraTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcCrocieraTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcCrocieraTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcCrocieraTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcCrocieraTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcCrocieraTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcCrocieraTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcCrocieraTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcCrocieraTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcCrocieraTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcCrocieraTable.Column.v_ver, value); }

		/* F_BLOCCO_INS_PENALE: String (12) */
		public String getFBloccoInsPenale() { return (String) get(CdcCrocieraTable.Column.f_blocco_ins_penale); }

		public void setFBloccoInsPenale(String value) { put(CdcCrocieraTable.Column.f_blocco_ins_penale, value); }


	}

}