
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_TIP_STATO}.
 *
 * <p>
 * Tabella che censisce gli stati generici di una entita':
   - Attivo:         'A'
   - Valido:        'V'
   - Annullato:   'N'
   - Cancellato: 'C'
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcTipStatoTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_tip_stato";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_stato}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_tip_stato}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_tip_stato}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_TIP_STATO}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato,

		/**
		 * Represents column {@code S_STATO} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * Descrizione Stato
		 * </p>
		 */
		s_stato,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_TIP_STATO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_TIP_STATO}.
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
	 * @param columns an array of columns of table {@code CDC_TIP_STATO}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcTipStatoTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TIP_STATO}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcTipStatoTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TIP_STATO}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcTipStatoTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TIP_STATO}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTipStatoTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TIP_STATO}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTipStatoTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}