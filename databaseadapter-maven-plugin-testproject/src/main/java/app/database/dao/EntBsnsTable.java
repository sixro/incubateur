
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
 * Represents {@code DAO} for table {@code ENT_BSNS}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class EntBsnsTable {

	private static final Log LOG = LogFactory.getLog(EntBsnsTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "ent_bsns";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM ent_bsns}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM ent_bsns}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM ent_bsns}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code ENT_BSNS}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code C_ENT_BSNS} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_ent_bsns, // data type: 3

		/**
		 * Represents column {@code N_ENT_BSNS} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_ent_bsns, // data type: 12

		/**
		 * Represents column {@code F_SNTM} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_sntm, // data type: 12

		/**
		 * Represents column {@code C_TIP_LVL_SIC} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tip_lvl_sic, // data type: 3

		/**
		 * Represents column {@code C_TIP_ENT_BSNS} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tip_ent_bsns, // data type: 3

		/**
		 * Represents column {@code X_TREE_PATH_ID} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		x_tree_path_id, // data type: 12

		/**
		 * Represents column {@code X_TREE_PATH_DESC} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		x_tree_path_desc, // data type: 12

		/**
		 * Represents column {@code F_INT} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_int, // data type: 12

		/**
		 * Represents column {@code F_RCRC_EST} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_rcrc_est, // data type: 12

		/**
		 * Represents column {@code D_MDF} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code ENT_BSNS}.
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
	
	public EntBsnsTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(EntBsnsTable.Record record) {
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

	public void update(EntBsnsTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(EntBsnsTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(EntBsnsTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<EntBsnsTable.Column, Object> what, Map<EntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<EntBsnsTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<EntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public EntBsnsTable.Record selectFirst(Map<EntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public EntBsnsTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<EntBsnsTable.Record> selectAll(Map<EntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<EntBsnsTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<EntBsnsTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<EntBsnsTable.Column, Object> allMatches, Callback<EntBsnsTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<EntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<EntBsnsTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code ENT_BSNS}
	 * @return names of specified columns
	 */
	public static String[] namesOf(EntBsnsTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code ENT_BSNS}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(EntBsnsTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<EntBsnsTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(EntBsnsTable.Column.values().length);
		}

		/* C_ENT_BSNS: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCEntBsns() { return (java.math.BigDecimal) get(EntBsnsTable.Column.c_ent_bsns); }

		public void setCEntBsns(java.math.BigDecimal value) { put(EntBsnsTable.Column.c_ent_bsns, value); }

		/* N_ENT_BSNS: String (12) */
		public String getNEntBsns() { return (String) get(EntBsnsTable.Column.n_ent_bsns); }

		public void setNEntBsns(String value) { put(EntBsnsTable.Column.n_ent_bsns, value); }

		/* F_SNTM: String (12) */
		public String getFSntm() { return (String) get(EntBsnsTable.Column.f_sntm); }

		public void setFSntm(String value) { put(EntBsnsTable.Column.f_sntm, value); }

		/* C_TIP_LVL_SIC: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTipLvlSic() { return (java.math.BigDecimal) get(EntBsnsTable.Column.c_tip_lvl_sic); }

		public void setCTipLvlSic(java.math.BigDecimal value) { put(EntBsnsTable.Column.c_tip_lvl_sic, value); }

		/* C_TIP_ENT_BSNS: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCTipEntBsns() { return (java.math.BigDecimal) get(EntBsnsTable.Column.c_tip_ent_bsns); }

		public void setCTipEntBsns(java.math.BigDecimal value) { put(EntBsnsTable.Column.c_tip_ent_bsns, value); }

		/* X_TREE_PATH_ID: String (12) */
		public String getXTreePathId() { return (String) get(EntBsnsTable.Column.x_tree_path_id); }

		public void setXTreePathId(String value) { put(EntBsnsTable.Column.x_tree_path_id, value); }

		/* X_TREE_PATH_DESC: String (12) */
		public String getXTreePathDesc() { return (String) get(EntBsnsTable.Column.x_tree_path_desc); }

		public void setXTreePathDesc(String value) { put(EntBsnsTable.Column.x_tree_path_desc, value); }

		/* F_INT: String (12) */
		public String getFInt() { return (String) get(EntBsnsTable.Column.f_int); }

		public void setFInt(String value) { put(EntBsnsTable.Column.f_int, value); }

		/* F_RCRC_EST: String (12) */
		public String getFRcrcEst() { return (String) get(EntBsnsTable.Column.f_rcrc_est); }

		public void setFRcrcEst(String value) { put(EntBsnsTable.Column.f_rcrc_est, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(EntBsnsTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(EntBsnsTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(EntBsnsTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(EntBsnsTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(EntBsnsTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(EntBsnsTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(EntBsnsTable.Column.d_ini); }

		public void setDIni(Date value) { put(EntBsnsTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(EntBsnsTable.Column.d_fin); }

		public void setDFin(Date value) { put(EntBsnsTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(EntBsnsTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(EntBsnsTable.Column.v_ver, value); }


	}

}