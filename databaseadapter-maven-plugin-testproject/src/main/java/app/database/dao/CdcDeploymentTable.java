
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
 * Represents {@code DAO} for table {@code CDC_DEPLOYMENT}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcDeploymentTable {

	private static final Log LOG = LogFactory.getLog(CdcDeploymentTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_deployment";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_deployment}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_deployment}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_deployment}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
	/**
	 * Contains all columns found in table {@code CDC_DEPLOYMENT}.
	 */
	public static enum Column {
		/**
		 * Represents column {@code D_ANNO} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Anno fiscale di validita' del deployment
		 * </p>
		 */
		d_anno, // data type: 3

		/**
		 * Represents column {@code G_DEPLOYMENT} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Sigla Codice Costa del deployment (C, B01, ...)
		 * </p>
		 */
		g_deployment, // data type: 12

		/**
		 * Represents column {@code S_DEPLOYMENT} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Descrizione del Deployment
		 * </p>
		 */
		s_deployment, // data type: 1111

		/**
		 * Represents column {@code C_DEPLOYMENT} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Codice interno del deployment (da sequence)
		 * </p>
		 */
		c_deployment, // data type: 3

		/**
		 * Represents column {@code Q_FORECAST} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		q_forecast, // data type: 12

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf, // data type: 93

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf, // data type: 12

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in, // data type: 12

		/**
		 * Represents column {@code D_INI} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini, // data type: 93

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin, // data type: 93

		/**
		 * Represents column {@code V_VER} of table {@code CDC_DEPLOYMENT}.
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
	
	public CdcDeploymentTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcDeploymentTable.Record record) {
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

	public void update(CdcDeploymentTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcDeploymentTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcDeploymentTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcDeploymentTable.Column, Object> what, Map<CdcDeploymentTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcDeploymentTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcDeploymentTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcDeploymentTable.Record selectFirst(Map<CdcDeploymentTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcDeploymentTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcDeploymentTable.Record> selectAll(Map<CdcDeploymentTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcDeploymentTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcDeploymentTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcDeploymentTable.Column, Object> allMatches, Callback<CdcDeploymentTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcDeploymentTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcDeploymentTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_DEPLOYMENT}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcDeploymentTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_DEPLOYMENT}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcDeploymentTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}
	
	public static class Record extends LinkedHashMap<CdcDeploymentTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcDeploymentTable.Column.values().length);
		}

		/* D_ANNO: java.math.BigDecimal (3) */
		public java.math.BigDecimal getDAnno() { return (java.math.BigDecimal) get(CdcDeploymentTable.Column.d_anno); }

		public void setDAnno(java.math.BigDecimal value) { put(CdcDeploymentTable.Column.d_anno, value); }

		/* G_DEPLOYMENT: String (12) */
		public String getGDeployment() { return (String) get(CdcDeploymentTable.Column.g_deployment); }

		public void setGDeployment(String value) { put(CdcDeploymentTable.Column.g_deployment, value); }

		/* S_DEPLOYMENT: String (1111) */
		public String getSDeployment() { return (String) get(CdcDeploymentTable.Column.s_deployment); }

		public void setSDeployment(String value) { put(CdcDeploymentTable.Column.s_deployment, value); }

		/* C_DEPLOYMENT: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCDeployment() { return (java.math.BigDecimal) get(CdcDeploymentTable.Column.c_deployment); }

		public void setCDeployment(java.math.BigDecimal value) { put(CdcDeploymentTable.Column.c_deployment, value); }

		/* Q_FORECAST: String (12) */
		public String getQForecast() { return (String) get(CdcDeploymentTable.Column.q_forecast); }

		public void setQForecast(String value) { put(CdcDeploymentTable.Column.q_forecast, value); }

		/* D_MDF: Date (93) */
		public Date getDMdf() { return (Date) get(CdcDeploymentTable.Column.d_mdf); }

		public void setDMdf(Date value) { put(CdcDeploymentTable.Column.d_mdf, value); }

		/* N_LOGIN_MDF: String (12) */
		public String getNLoginMdf() { return (String) get(CdcDeploymentTable.Column.n_login_mdf); }

		public void setNLoginMdf(String value) { put(CdcDeploymentTable.Column.n_login_mdf, value); }

		/* N_LOGIN_IN: String (12) */
		public String getNLoginIn() { return (String) get(CdcDeploymentTable.Column.n_login_in); }

		public void setNLoginIn(String value) { put(CdcDeploymentTable.Column.n_login_in, value); }

		/* D_INI: Date (93) */
		public Date getDIni() { return (Date) get(CdcDeploymentTable.Column.d_ini); }

		public void setDIni(Date value) { put(CdcDeploymentTable.Column.d_ini, value); }

		/* D_FIN: Date (93) */
		public Date getDFin() { return (Date) get(CdcDeploymentTable.Column.d_fin); }

		public void setDFin(Date value) { put(CdcDeploymentTable.Column.d_fin, value); }

		/* V_VER: java.math.BigDecimal (3) */
		public java.math.BigDecimal getVVer() { return (java.math.BigDecimal) get(CdcDeploymentTable.Column.v_ver); }

		public void setVVer(java.math.BigDecimal value) { put(CdcDeploymentTable.Column.v_ver, value); }


	}

}