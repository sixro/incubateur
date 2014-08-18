
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
 * Represents {@code DAO} for table {@code CDC_FORNITORE}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcFornitoreTable {

	private static final Log LOG = LogFactory.getLog(CdcFornitoreTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_fornitore";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_fornitore}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_fornitore}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_fornitore}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_FORNITORE}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_TIP_FORNITORE} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice della Tipologia di Azienda Fornitrice
		 * </p>
		 */
		c_tip_fornitore, // data type: 12

		/**
		 * Represents column {@code F_ONBEHALF} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag Onbehalf. Assume i valori Y/N. Ereditato da database MASS
		 * </p>
		 */
		f_onbehalf, // data type: 1

		/**
		 * Represents column {@code F_LOCAL} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag Local. Assume i valori Y/N. Ereditato da database MASS
		 * </p>
		 */
		f_local, // data type: 1

		/**
		 * Represents column {@code F_UNAT} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag UNAT. Assume i valori Y/N. Ereditato da database MASS, campo FLAGUNAT
		 * </p>
		 */
		f_unat, // data type: 1

		/**
		 * Represents column {@code F_CNSG_SETML} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag che indica se il Fornitore effettua consegne settimanali. Assume i valori Y/N. Ereditato da database MASS, campo WEEKDELIVERY
		 * </p>
		 */
		f_cnsg_setml, // data type: 1

		/**
		 * Represents column {@code C_ENT_BSNS_SOC_FORNITORE} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_soc_fornitore, // data type: 3

		/**
		 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_valuta, // data type: 3

		/**
		 * Represents column {@code C_CLSF_MERG} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice interno della classificazione merceologica
		 * </p>
		 */
		c_clsf_merg, // data type: 3

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato, // data type: 1

		/**
		 * Represents column {@code C_TIP_PRDT} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Chiave interna della categoria di prodotto
		 * </p>
		 */
		c_tip_prdt, // data type: 3

		/**
		 * Represents column {@code F_IBAN} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * vale 'Y' se la country del fornitore aderisce al circuito IBAN
		 * </p>
		 */
		f_iban, // data type: 1

		/**
		 * Represents column {@code F_UE} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Vale 'Y' se la country del fornitore appartiene all'Unione Europea
		 * </p>
		 */
		f_ue, // data type: 1

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver, // data type: 3

		/**
		 * Represents column {@code C_COMPAGNIA} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Idenitificatore univoco compagnia (FK)
		 * </p>
		 */
		c_compagnia // data type: 12

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcFornitoreTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcFornitoreTable.Record record) {
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

	public void update(CdcFornitoreTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcFornitoreTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcFornitoreTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcFornitoreTable.Column, Object> what, Map<CdcFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcFornitoreTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcFornitoreTable.Record selectFirst(Map<CdcFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcFornitoreTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcFornitoreTable.Record> selectAll(Map<CdcFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcFornitoreTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcFornitoreTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcFornitoreTable.Column, Object> allMatches, Callback<CdcFornitoreTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcFornitoreTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcFornitoreTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcFornitoreTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcFornitoreTable.Column.values().length);
		}

		/* C_TIP_FORNITORE: String (12) */
		public String getCTipFornitore() { return (String) get(CdcFornitoreTable.Column.c_tip_fornitore); }

		public void setCTipFornitore(String value) { put(CdcFornitoreTable.Column.c_tip_fornitore, value); }

		/* F_ONBEHALF: String (1) */
		public String getFOnbehalf() { return (String) get(CdcFornitoreTable.Column.f_onbehalf); }

		public void setFOnbehalf(String value) { put(CdcFornitoreTable.Column.f_onbehalf, value); }

		/* F_LOCAL: String (1) */
		public String getFLocal() { return (String) get(CdcFornitoreTable.Column.f_local); }

		public void setFLocal(String value) { put(CdcFornitoreTable.Column.f_local, value); }

		/* F_UNAT: String (1) */
		public String getFUnat() { return (String) get(CdcFornitoreTable.Column.f_unat); }

		public void setFUnat(String value) { put(CdcFornitoreTable.Column.f_unat, value); }

		/* F_CNSG_SETML: String (1) */
		public String getFCnsgSetml() { return (String) get(CdcFornitoreTable.Column.f_cnsg_setml); }

		public void setFCnsgSetml(String value) { put(CdcFornitoreTable.Column.f_cnsg_setml, value); }

		/* C_ENT_BSNS_SOC_FORNITORE: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsSocFornitore() { return (java.math.BigDecimal) get(CdcFornitoreTable.Column.c_ent_bsns_soc_fornitore); }

		public void setCEntBsnsSocFornitore(java.math.BigDecimal value) { put(CdcFornitoreTable.Column.c_ent_bsns_soc_fornitore, value); }

		/* C_ENT_BSNS_VALUTA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsValuta() { return (java.math.BigDecimal) get(CdcFornitoreTable.Column.c_ent_bsns_valuta); }

		public void setCEntBsnsValuta(java.math.BigDecimal value) { put(CdcFornitoreTable.Column.c_ent_bsns_valuta, value); }

		/* C_CLSF_MERG: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCClsfMerg() { return (java.math.BigDecimal) get(CdcFornitoreTable.Column.c_clsf_merg); }

		public void setCClsfMerg(java.math.BigDecimal value) { put(CdcFornitoreTable.Column.c_clsf_merg, value); }

		/* A_STATO: String (1) */
		public String getAStato() { return (String) get(CdcFornitoreTable.Column.a_stato); }

		public void setAStato(String value) { put(CdcFornitoreTable.Column.a_stato, value); }

		/* C_TIP_PRDT: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTipPrdt() { return (java.math.BigDecimal) get(CdcFornitoreTable.Column.c_tip_prdt); }

		public void setCTipPrdt(java.math.BigDecimal value) { put(CdcFornitoreTable.Column.c_tip_prdt, value); }

		/* F_IBAN: String (1) */
		public String getFIban() { return (String) get(CdcFornitoreTable.Column.f_iban); }

		public void setFIban(String value) { put(CdcFornitoreTable.Column.f_iban, value); }

		/* F_UE: String (1) */
		public String getFUe() { return (String) get(CdcFornitoreTable.Column.f_ue); }

		public void setFUe(String value) { put(CdcFornitoreTable.Column.f_ue, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcFornitoreTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcFornitoreTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcFornitoreTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcFornitoreTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcFornitoreTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcFornitoreTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcFornitoreTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcFornitoreTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcFornitoreTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcFornitoreTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcFornitoreTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcFornitoreTable.Column.v_ver, value); }

		/* C_COMPAGNIA: String (12) */
		public String getCCompagnia() { return (String) get(CdcFornitoreTable.Column.c_compagnia); }

		public void setCCompagnia(String value) { put(CdcFornitoreTable.Column.c_compagnia, value); }


	}

}