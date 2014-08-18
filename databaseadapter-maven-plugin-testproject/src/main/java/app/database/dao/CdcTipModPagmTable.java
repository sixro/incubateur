
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
 * Represents {@code DAO} for table {@code CDC_TIP_MOD_PAGM}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcTipModPagmTable {

	private static final Log LOG = LogFactory.getLog(CdcTipModPagmTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_tip_mod_pagm";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_mod_pagm}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_tip_mod_pagm}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_tip_mod_pagm}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_TIP_MOD_PAGM}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_TIP_MOD_PAGM} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * Codice Modalita di pagamento
		 * </p>
		 */
		c_tip_mod_pagm, // data type: 3

		/**
		 * Represents column {@code G_TIP_MOD_PAGM} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * Codice Costa della Modalita di pagamento (ereditato da MASS)
		 * </p>
		 */
		g_tip_mod_pagm, // data type: 12

		/**
		 * Represents column {@code S_TIP_MOD_PAGM} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * Descrizione della Modalita di pagamento
		 * </p>
		 */
		s_tip_mod_pagm, // data type: 1111

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_TIP_MOD_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_TIP_MOD_PAGM}.
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
	
	public CdcTipModPagmTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcTipModPagmTable.Record record) {
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

	public void update(CdcTipModPagmTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcTipModPagmTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcTipModPagmTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcTipModPagmTable.Column, Object> what, Map<CdcTipModPagmTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcTipModPagmTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcTipModPagmTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcTipModPagmTable.Record selectFirst(Map<CdcTipModPagmTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcTipModPagmTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcTipModPagmTable.Record> selectAll(Map<CdcTipModPagmTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcTipModPagmTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcTipModPagmTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcTipModPagmTable.Column, Object> allMatches, Callback<CdcTipModPagmTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcTipModPagmTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcTipModPagmTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTipModPagmTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTipModPagmTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcTipModPagmTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcTipModPagmTable.Column.values().length);
		}

		/* C_TIP_MOD_PAGM: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTipModPagm() { return (java.math.BigDecimal) get(CdcTipModPagmTable.Column.c_tip_mod_pagm); }

		public void setCTipModPagm(java.math.BigDecimal value) { put(CdcTipModPagmTable.Column.c_tip_mod_pagm, value); }

		/* G_TIP_MOD_PAGM: String (12) */
		public String getGTipModPagm() { return (String) get(CdcTipModPagmTable.Column.g_tip_mod_pagm); }

		public void setGTipModPagm(String value) { put(CdcTipModPagmTable.Column.g_tip_mod_pagm, value); }

		/* S_TIP_MOD_PAGM: String (1111) */
		public String getSTipModPagm() { return (String) get(CdcTipModPagmTable.Column.s_tip_mod_pagm); }

		public void setSTipModPagm(String value) { put(CdcTipModPagmTable.Column.s_tip_mod_pagm, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcTipModPagmTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcTipModPagmTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcTipModPagmTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcTipModPagmTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcTipModPagmTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcTipModPagmTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcTipModPagmTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcTipModPagmTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcTipModPagmTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcTipModPagmTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcTipModPagmTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcTipModPagmTable.Column.v_ver, value); }


	}

}