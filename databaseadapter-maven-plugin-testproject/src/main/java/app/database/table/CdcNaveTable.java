
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_NAVE}.
 *
 * <p>
 * Elenco delle Navi della flotta Costa
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcNaveTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_nave";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_nave}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_nave}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_nave}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
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
		c_nave,

		/**
		 * Represents column {@code N_NAVE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Ship name
		 * </p>
		 */
		n_nave,

		/**
		 * Represents column {@code C_EASY} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codifica Nave easy
		 * </p>
		 */
		c_easy,

		/**
		 * Represents column {@code C_ORACLE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codifica Nave Oracle
		 * </p>
		 */
		c_oracle,

		/**
		 * Represents column {@code C_COMPAGNIA} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codice della compagnia (vedi cdc_compagnia)
		 * </p>
		 */
		c_compagnia,

		/**
		 * Represents column {@code N_PROPRIETARIO} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Owner/Operator
		 * </p>
		 */
		n_proprietario,

		/**
		 * Represents column {@code N_BANDIERA} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Flag
		 * </p>
		 */
		n_bandiera,

		/**
		 * Represents column {@code N_PORTO_REGISTRAZ} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Port of registry
		 * </p>
		 */
		n_porto_registraz,

		/**
		 * Represents column {@code N_NBR} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Official Nbr.
		 * </p>
		 */
		n_nbr,

		/**
		 * Represents column {@code N_IMO} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * I.M.O. number
		 * </p>
		 */
		n_imo,

		/**
		 * Represents column {@code C_ENT_BSNS_NAVE} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_nave,

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_NAVE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_NAVE}.
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
	 * @param columns an array of columns of table {@code CDC_NAVE}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcNaveTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_NAVE}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcNaveTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_NAVE}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcNaveTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
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

}