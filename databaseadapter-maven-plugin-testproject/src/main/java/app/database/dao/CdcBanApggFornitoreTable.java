
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
 * Represents {@code DAO} for table {@code CDC_BAN_APGG_FORNITORE}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcBanApggFornitoreTable {

	private static final Log LOG = LogFactory.getLog(CdcBanApggFornitoreTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_ban_apgg_fornitore";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_ban_apgg_fornitore}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_ban_apgg_fornitore}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_ban_apgg_fornitore}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_BAN_APGG_FORNITORE}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code F_PRIMARIA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Indica se si tratta della banca di appoggio primaria
		 * </p>
		 */
		f_primaria, // data type: 1

		/**
		 * Represents column {@code V_CC} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Numero di conto corrente
		 * </p>
		 */
		v_cc, // data type: 1111

		/**
		 * Represents column {@code C_ENT_BSNS_SOC_FORNITORE} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice fornitore
		 * </p>
		 */
		c_ent_bsns_soc_fornitore, // data type: 3

		/**
		 * Represents column {@code P_ORD} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Ordine del rapporto nella lista di rapporti per un fornitore
		 * </p>
		 */
		p_ord, // data type: 3

		/**
		 * Represents column {@code C_BAN_APGG_FORNITORE} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Chiave interna del rapporto bancario
		 * </p>
		 */
		c_ban_apgg_fornitore, // data type: 3

		/**
		 * Represents column {@code F_ITA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Indica se la banca/filiale sia Italiana o meno.
		 * </p>
		 */
		f_ita, // data type: 1

		/**
		 * Represents column {@code C_BAN_APGG} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice MASS della Banca/Filiale
		 * </p>
		 */
		c_ban_apgg, // data type: 1111

		/**
		 * Represents column {@code N_BAN_APGG} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Nome della Banca/Filiale
		 * </p>
		 */
		n_ban_apgg, // data type: 1111

		/**
		 * Represents column {@code C_ABI} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice ABI per le Banche italiane
		 * </p>
		 */
		c_abi, // data type: 12

		/**
		 * Represents column {@code C_CAB} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice CAB per le filiali italiane
		 * </p>
		 */
		c_cab, // data type: 12

		/**
		 * Represents column {@code C_SWIFT} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice internazionale Swift
		 * </p>
		 */
		c_swift, // data type: 1111

		/**
		 * Represents column {@code C_ABA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice ABA
		 * </p>
		 */
		c_aba, // data type: 1111

		/**
		 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice Valuta per la filiale/banca
		 * </p>
		 */
		c_ent_bsns_valuta, // data type: 3

		/**
		 * Represents column {@code C_IBAN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice IBAN della Banca
		 * </p>
		 */
		c_iban, // data type: 1111

		/**
		 * Represents column {@code C_CIN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice CIN della Banca
		 * </p>
		 */
		c_cin, // data type: 12

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_BAN_APGG_FORNITORE}.
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
	
	public CdcBanApggFornitoreTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcBanApggFornitoreTable.Record record) {
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

	public void update(CdcBanApggFornitoreTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcBanApggFornitoreTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcBanApggFornitoreTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcBanApggFornitoreTable.Column, Object> what, Map<CdcBanApggFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcBanApggFornitoreTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcBanApggFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcBanApggFornitoreTable.Record selectFirst(Map<CdcBanApggFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcBanApggFornitoreTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcBanApggFornitoreTable.Record> selectAll(Map<CdcBanApggFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcBanApggFornitoreTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcBanApggFornitoreTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcBanApggFornitoreTable.Column, Object> allMatches, Callback<CdcBanApggFornitoreTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcBanApggFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcBanApggFornitoreTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcBanApggFornitoreTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcBanApggFornitoreTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcBanApggFornitoreTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcBanApggFornitoreTable.Column.values().length);
		}

		/* F_PRIMARIA: String (1) */
		public String getFPrimaria() { return (String) get(CdcBanApggFornitoreTable.Column.f_primaria); }

		public void setFPrimaria(String value) { put(CdcBanApggFornitoreTable.Column.f_primaria, value); }

		/* V_CC: String (1111) */
		public String getVCc() { return (String) get(CdcBanApggFornitoreTable.Column.v_cc); }

		public void setVCc(String value) { put(CdcBanApggFornitoreTable.Column.v_cc, value); }

		/* C_ENT_BSNS_SOC_FORNITORE: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsSocFornitore() { return (java.math.BigDecimal) get(CdcBanApggFornitoreTable.Column.c_ent_bsns_soc_fornitore); }

		public void setCEntBsnsSocFornitore(java.math.BigDecimal value) { put(CdcBanApggFornitoreTable.Column.c_ent_bsns_soc_fornitore, value); }

		/* P_ORD: java.math.BigDecimal (3) */
		public java.math.BigDecimal getPOrd() { return (java.math.BigDecimal) get(CdcBanApggFornitoreTable.Column.p_ord); }

		public void setPOrd(java.math.BigDecimal value) { put(CdcBanApggFornitoreTable.Column.p_ord, value); }

		/* C_BAN_APGG_FORNITORE: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCBanApggFornitore() { return (java.math.BigDecimal) get(CdcBanApggFornitoreTable.Column.c_ban_apgg_fornitore); }

		public void setCBanApggFornitore(java.math.BigDecimal value) { put(CdcBanApggFornitoreTable.Column.c_ban_apgg_fornitore, value); }

		/* F_ITA: String (1) */
		public String getFIta() { return (String) get(CdcBanApggFornitoreTable.Column.f_ita); }

		public void setFIta(String value) { put(CdcBanApggFornitoreTable.Column.f_ita, value); }

		/* C_BAN_APGG: String (1111) */
		public String getCBanApgg() { return (String) get(CdcBanApggFornitoreTable.Column.c_ban_apgg); }

		public void setCBanApgg(String value) { put(CdcBanApggFornitoreTable.Column.c_ban_apgg, value); }

		/* N_BAN_APGG: String (1111) */
		public String getNBanApgg() { return (String) get(CdcBanApggFornitoreTable.Column.n_ban_apgg); }

		public void setNBanApgg(String value) { put(CdcBanApggFornitoreTable.Column.n_ban_apgg, value); }

		/* C_ABI: String (12) */
		public String getCAbi() { return (String) get(CdcBanApggFornitoreTable.Column.c_abi); }

		public void setCAbi(String value) { put(CdcBanApggFornitoreTable.Column.c_abi, value); }

		/* C_CAB: String (12) */
		public String getCCab() { return (String) get(CdcBanApggFornitoreTable.Column.c_cab); }

		public void setCCab(String value) { put(CdcBanApggFornitoreTable.Column.c_cab, value); }

		/* C_SWIFT: String (1111) */
		public String getCSwift() { return (String) get(CdcBanApggFornitoreTable.Column.c_swift); }

		public void setCSwift(String value) { put(CdcBanApggFornitoreTable.Column.c_swift, value); }

		/* C_ABA: String (1111) */
		public String getCAba() { return (String) get(CdcBanApggFornitoreTable.Column.c_aba); }

		public void setCAba(String value) { put(CdcBanApggFornitoreTable.Column.c_aba, value); }

		/* C_ENT_BSNS_VALUTA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsValuta() { return (java.math.BigDecimal) get(CdcBanApggFornitoreTable.Column.c_ent_bsns_valuta); }

		public void setCEntBsnsValuta(java.math.BigDecimal value) { put(CdcBanApggFornitoreTable.Column.c_ent_bsns_valuta, value); }

		/* C_IBAN: String (1111) */
		public String getCIban() { return (String) get(CdcBanApggFornitoreTable.Column.c_iban); }

		public void setCIban(String value) { put(CdcBanApggFornitoreTable.Column.c_iban, value); }

		/* C_CIN: String (12) */
		public String getCCin() { return (String) get(CdcBanApggFornitoreTable.Column.c_cin); }

		public void setCCin(String value) { put(CdcBanApggFornitoreTable.Column.c_cin, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcBanApggFornitoreTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcBanApggFornitoreTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcBanApggFornitoreTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcBanApggFornitoreTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcBanApggFornitoreTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcBanApggFornitoreTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcBanApggFornitoreTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcBanApggFornitoreTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcBanApggFornitoreTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcBanApggFornitoreTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcBanApggFornitoreTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcBanApggFornitoreTable.Column.v_ver, value); }


	}

}