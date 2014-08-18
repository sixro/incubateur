
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_PARM_PAGM}.
 *
 * <p>
 * Ogni record raggruppa l'insieme delle condizioni di pagamento cui e' associato il Fornitore
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcParmPagmTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_parm_pagm";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_parm_pagm}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_parm_pagm}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_parm_pagm}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_PARM_PAGM}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code C_ENT_BSNS_SOC} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_soc,

		/**
		 * Represents column {@code C_TIP_COND_PAGM} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * Codice Condizione di pagamento
		 * </p>
		 */
		c_tip_cond_pagm,

		/**
		 * Represents column {@code C_TIP_MOD_PAGM} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * Codice Modalita di pagamento
		 * </p>
		 */
		c_tip_mod_pagm,

		/**
		 * Represents column {@code C_TIP_GRP_PAGM} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * Codice del Gruppo di pagamento
		 * </p>
		 */
		c_tip_grp_pagm,

		/**
		 * Represents column {@code C_TIP_TOLLN_FAT} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * Codice interno del tipo di tolleranza
		 * </p>
		 */
		c_tip_tolln_fat,

		/**
		 * Represents column {@code F_DICHR_INTT} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * Flag che indica se il Fornitore ha siglato una dichiarazione di Itenti con Costa.
		 * </p>
		 */
		f_dichr_intt,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_PARM_PAGM}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_PARM_PAGM}.
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
	 * @param columns an array of columns of table {@code CDC_PARM_PAGM}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcParmPagmTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_PARM_PAGM}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcParmPagmTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_PARM_PAGM}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcParmPagmTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_PARM_PAGM}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcParmPagmTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_PARM_PAGM}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcParmPagmTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}