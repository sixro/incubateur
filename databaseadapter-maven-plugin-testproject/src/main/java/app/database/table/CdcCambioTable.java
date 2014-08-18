
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_CAMBIO}.
 *
 * <p>
 * Valori dei tassi do conversione tra le monete censite in CDC_VALUTA. I cambi sono legati al Deployment per il quale valgono. All'interno del singolo Deployment, poi, c'è un ulteriore suddivisione in periodi individuata in tabella dal valore del campo G_PERIODO.
Per ogni valuta di partenza (C_ENT_BSNS_VALUTA_DA) il valore del tasso di cdambio V_CAMBIO indica il fattore per cui moltiplicarla per ottenere la conversione nella valuta di destinazione (C_ENT_BSNS_VALUTA_A)

 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCambioTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_cambio";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_cambio}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_cambio}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_cambio}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_CAMBIO}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code G_PERIODO} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * Periodo di vvalidita' del cambio
		 * </p>
		 */
		g_periodo,

		/**
		 * Represents column {@code V_CAMBIO} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * Tasso di cambio
		 * </p>
		 */
		v_cambio,

		/**
		 * Represents column {@code V_CAMBIO_FINALE} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * Tasso di cambio finale
		 * </p>
		 */
		v_cambio_finale,

		/**
		 * Represents column {@code C_ENT_BSNS_VALUTA_A} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * Valuta destinazione
		 * </p>
		 */
		c_ent_bsns_valuta_a,

		/**
		 * Represents column {@code C_ENT_BSNS_VALUTA_DA} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * Valuta fonte

		 * </p>
		 */
		c_ent_bsns_valuta_da,

		/**
		 * Represents column {@code C_DEPLOYMENT} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * Codice interno del deployment (da sequence)
		 * </p>
		 */
		c_deployment,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_CAMBIO}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_CAMBIO}.
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
	 * @param columns an array of columns of table {@code CDC_CAMBIO}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcCambioTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_CAMBIO}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcCambioTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_CAMBIO}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcCambioTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_CAMBIO}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCambioTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_CAMBIO}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCambioTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}