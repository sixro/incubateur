
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_TRATTA_CROCIERA}.
 *
 * <p>
 * Dettaglio di un Piano Crociera. Elenca il percorso della Nave nei giorni di crociera distinguendo navigazione da scali nei porti.
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcTrattaCrocieraTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_tratta_crociera";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tratta_crociera}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_tratta_crociera}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_tratta_crociera}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_TRATTA_CROCIERA}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code C_TRATTA_CROCIERA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		c_tratta_crociera,

		/**
		 * Represents column {@code D_INI_TRATTA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Data e orario di inizio tratta
		 * </p>
		 */
		d_ini_tratta,

		/**
		 * Represents column {@code D_FIN_TRATTA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Data e orario di fine tratta
		 * </p>
		 */
		d_fin_tratta,

		/**
		 * Represents column {@code C_PIANO_CROCIERA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco (da sequence) della tratta di crociera
		 * </p>
		 */
		c_piano_crociera,

		/**
		 * Represents column {@code C_TIP_TRATTA_CROCIERA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Codice del tipo di Stato di attraversamento di una determinata tratta del piano di Crociera.
Valori ammissibili:
  'P' - Partenza (inizio Crociera)
  'N' - Navigazione
  'S' - Scalo
  'D' - Arrivo (termine Crociera)
  'A' - Attracco
  'T' - Transito
		 * </p>
		 */
		c_tip_tratta_crociera,

		/**
		 * Represents column {@code C_ENT_BSNS_PORTO} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Codice del Porto corrispondente alla tratta
		 * </p>
		 */
		c_ent_bsns_porto,

		/**
		 * Represents column {@code F_RADA} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_rada,

		/**
		 * Represents column {@code F_RIFORNIMENTO} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_rifornimento,

		/**
		 * Represents column {@code F_NASCONDI_INTRANET} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_nascondi_intranet,

		/**
		 * Represents column {@code X_NOT} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * Note libere sulla tratta
		 * </p>
		 */
		x_not,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_TRATTA_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_TRATTA_CROCIERA}.
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
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcTrattaCrocieraTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcTrattaCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcTrattaCrocieraTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTrattaCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_TRATTA_CROCIERA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcTrattaCrocieraTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}