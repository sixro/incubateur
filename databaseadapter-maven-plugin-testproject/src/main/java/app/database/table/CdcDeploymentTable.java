
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_DEPLOYMENT}.
 *
 * <p>
 * Tabella che riporta I Deployment Costa (coppie "Anno/Tipo Deployment") che si associano a Crociere e Cambi delle valute per sapere se si riferiscono allo schedule correntemente approvato (Consuntivo) piuttosto che a Budget o Forecast.
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcDeploymentTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_deployment";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_deployment}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_deployment}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_deployment}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
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
		d_anno,

		/**
		 * Represents column {@code G_DEPLOYMENT} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Sigla Codice Costa del deployment (C, B01, ...)
		 * </p>
		 */
		g_deployment,

		/**
		 * Represents column {@code S_DEPLOYMENT} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Descrizione del Deployment
		 * </p>
		 */
		s_deployment,

		/**
		 * Represents column {@code C_DEPLOYMENT} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * Codice interno del deployment (da sequence)
		 * </p>
		 */
		c_deployment,

		/**
		 * Represents column {@code Q_FORECAST} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		q_forecast,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_DEPLOYMENT}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver
	};
	
	/**
	 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_DEPLOYMENT}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcDeploymentTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_DEPLOYMENT}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcDeploymentTable.Column[] columns) {
		return new StringBuilder("INSERT INTO ")
			.append(TABLE_NAME)
			.append("(")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(") VALUES (")
			.append(StringUtils.join(Collections.nCopies(columns.length, "?"), ", "))
			.append(")")
			.toString();
	}

	/**
	 * Returns an &quot;update&quot; {@code SQL} using specified columns in {@code SET} clause.
	 *
	 * @param columns an array of columns of table {@code CDC_DEPLOYMENT}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcDeploymentTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
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

}