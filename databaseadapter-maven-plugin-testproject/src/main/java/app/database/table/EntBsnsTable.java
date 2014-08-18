
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code ENT_BSNS}.
 *
 * <p>
 * 
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class EntBsnsTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "ent_bsns";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM ent_bsns}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM ent_bsns}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM ent_bsns}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
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
		c_ent_bsns,

		/**
		 * Represents column {@code N_ENT_BSNS} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_ent_bsns,

		/**
		 * Represents column {@code F_SNTM} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_sntm,

		/**
		 * Represents column {@code C_TIP_LVL_SIC} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tip_lvl_sic,

		/**
		 * Represents column {@code C_TIP_ENT_BSNS} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tip_ent_bsns,

		/**
		 * Represents column {@code X_TREE_PATH_ID} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		x_tree_path_id,

		/**
		 * Represents column {@code X_TREE_PATH_DESC} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		x_tree_path_desc,

		/**
		 * Represents column {@code F_INT} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_int,

		/**
		 * Represents column {@code F_RCRC_EST} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_rcrc_est,

		/**
		 * Represents column {@code D_MDF} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code ENT_BSNS}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code ENT_BSNS}.
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
	 * @param columns an array of columns of table {@code ENT_BSNS}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(EntBsnsTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code ENT_BSNS}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(EntBsnsTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code ENT_BSNS}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(EntBsnsTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
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

}