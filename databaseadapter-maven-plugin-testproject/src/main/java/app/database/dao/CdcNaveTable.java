
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
 * Represents {@code DAO} for table {@code CDC_NAVE}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcNaveTable {

	private static final Log LOG = LogFactory.getLog(CdcNaveTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_nave";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_nave}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_nave}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_nave}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_NAVE}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_NAVE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codifica Nave
		 * </p>
		 */
		c_nave, // data type: 12

		/**
		 * Represents column {@code N_NAVE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Ship name
		 * </p>
		 */
		n_nave, // data type: 1111

		/**
		 * Represents column {@code C_EASY} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codifica Nave easy
		 * </p>
		 */
		c_easy, // data type: 12

		/**
		 * Represents column {@code C_ORACLE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codifica Nave Oracle
		 * </p>
		 */
		c_oracle, // data type: 12

		/**
		 * Represents column {@code C_COMPAGNIA} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codice della compagnia (vedi cdc_compagnia)
		 * </p>
		 */
		c_compagnia, // data type: 12

		/**
		 * Represents column {@code N_PROPRIETARIO} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Owner/Operator
		 * </p>
		 */
		n_proprietario, // data type: 1111

		/**
		 * Represents column {@code N_BANDIERA} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Flag
		 * </p>
		 */
		n_bandiera, // data type: 1111

		/**
		 * Represents column {@code N_PORTO_REGISTRAZ} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Port of registry
		 * </p>
		 */
		n_porto_registraz, // data type: 1111

		/**
		 * Represents column {@code N_NBR} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Official Nbr.
		 * </p>
		 */
		n_nbr, // data type: 12

		/**
		 * Represents column {@code N_IMO} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * I.M.O. number
		 * </p>
		 */
		n_imo, // data type: 12

		/**
		 * Represents column {@code C_ENT_BSNS_NAVE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_nave, // data type: 3

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato, // data type: 1

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_NAVE}.
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
	
	public CdcNaveTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcNaveTable.Record record) {
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

	public void update(CdcNaveTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcNaveTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcNaveTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcNaveTable.Column, Object> what, Map<CdcNaveTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcNaveTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcNaveTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcNaveTable.Record selectFirst(Map<CdcNaveTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcNaveTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcNaveTable.Record> selectAll(Map<CdcNaveTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcNaveTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcNaveTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcNaveTable.Column, Object> allMatches, Callback<CdcNaveTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcNaveTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcNaveTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_NAVE}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcNaveTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_NAVE}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcNaveTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcNaveTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcNaveTable.Column.values().length);
		}

		/* C_NAVE: String (12) */
		public String getCNave() { return (String) get(CdcNaveTable.Column.c_nave); }

		public void setCNave(String value) { put(CdcNaveTable.Column.c_nave, value); }

		/* N_NAVE: String (1111) */
		public String getNNave() { return (String) get(CdcNaveTable.Column.n_nave); }

		public void setNNave(String value) { put(CdcNaveTable.Column.n_nave, value); }

		/* C_EASY: String (12) */
		public String getCEasy() { return (String) get(CdcNaveTable.Column.c_easy); }

		public void setCEasy(String value) { put(CdcNaveTable.Column.c_easy, value); }

		/* C_ORACLE: String (12) */
		public String getCOracle() { return (String) get(CdcNaveTable.Column.c_oracle); }

		public void setCOracle(String value) { put(CdcNaveTable.Column.c_oracle, value); }

		/* C_COMPAGNIA: String (12) */
		public String getCCompagnia() { return (String) get(CdcNaveTable.Column.c_compagnia); }

		public void setCCompagnia(String value) { put(CdcNaveTable.Column.c_compagnia, value); }

		/* N_PROPRIETARIO: String (1111) */
		public String getNProprietario() { return (String) get(CdcNaveTable.Column.n_proprietario); }

		public void setNProprietario(String value) { put(CdcNaveTable.Column.n_proprietario, value); }

		/* N_BANDIERA: String (1111) */
		public String getNBandiera() { return (String) get(CdcNaveTable.Column.n_bandiera); }

		public void setNBandiera(String value) { put(CdcNaveTable.Column.n_bandiera, value); }

		/* N_PORTO_REGISTRAZ: String (1111) */
		public String getNPortoRegistraz() { return (String) get(CdcNaveTable.Column.n_porto_registraz); }

		public void setNPortoRegistraz(String value) { put(CdcNaveTable.Column.n_porto_registraz, value); }

		/* N_NBR: String (12) */
		public String getNNbr() { return (String) get(CdcNaveTable.Column.n_nbr); }

		public void setNNbr(String value) { put(CdcNaveTable.Column.n_nbr, value); }

		/* N_IMO: String (12) */
		public String getNImo() { return (String) get(CdcNaveTable.Column.n_imo); }

		public void setNImo(String value) { put(CdcNaveTable.Column.n_imo, value); }

		/* C_ENT_BSNS_NAVE: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsnsNave() { return (java.math.BigDecimal) get(CdcNaveTable.Column.c_ent_bsns_nave); }

		public void setCEntBsnsNave(java.math.BigDecimal value) { put(CdcNaveTable.Column.c_ent_bsns_nave, value); }

		/* A_STATO: String (1) */
		public String getAStato() { return (String) get(CdcNaveTable.Column.a_stato); }

		public void setAStato(String value) { put(CdcNaveTable.Column.a_stato, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcNaveTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcNaveTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcNaveTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcNaveTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcNaveTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcNaveTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcNaveTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcNaveTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcNaveTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcNaveTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcNaveTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcNaveTable.Column.v_ver, value); }


	}

}