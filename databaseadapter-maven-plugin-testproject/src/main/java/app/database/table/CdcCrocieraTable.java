
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_CROCIERA}.
 *
 * <p>
 * Censimento crociera associa nave ad una data di inzio e fine navigazione
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCrocieraTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_crociera";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_crociera}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_crociera}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_crociera}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_CROCIERA}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code C_CROCIERA_COSTA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice Crociera. Composto sempre da 6 caratteri cosi' ripartiti:
        <NN><CC><AAAA>
dove:
NN: Codice Nave Costa (CDC_NAVE.C_NAVE)
CC: Numero progressivo Crociera per la Nave, sempre di 2 char
AAAA: Anno della crociera
		 * </p>
		 */
		c_crociera_costa,

		/**
		 * Represents column {@code D_INI_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Data di inizio Crociera
		 * </p>
		 */
		d_ini_crociera,

		/**
		 * Represents column {@code D_FIN_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Data di Fine Crociera
		 * </p>
		 */
		d_fin_crociera,

		/**
		 * Represents column {@code V_DURATA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Durata della Crociera in giorni
		 * </p>
		 */
		v_durata,

		/**
		 * Represents column {@code S_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Descrizione Crociera
		 * </p>
		 */
		s_crociera,

		/**
		 * Represents column {@code N_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Nome (Descrizione breve) della Crociera
		 * </p>
		 */
		n_crociera,

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato,

		/**
		 * Represents column {@code C_DEPLOYMENT} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice interno del deployment (da sequence)
		 * </p>
		 */
		c_deployment,

		/**
		 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_crociera,

		/**
		 * Represents column {@code C_TIP_CROCIERA} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice tipo crociera
		 * </p>
		 */
		c_tip_crociera,

		/**
		 * Represents column {@code F_NASCONDI_INTRANET} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		f_nascondi_intranet,

		/**
		 * Represents column {@code N_STAGIONE} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_stagione,

		/**
		 * Represents column {@code C_ENT_BSNS_NAVE} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_nave,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver,

		/**
		 * Represents column {@code F_BLOCCO_INS_PENALE} of table {@code CDC_CROCIERA}.
		 *
		 * <p>
		 * Flag che regola l'inserimento delle penali: se Y sono inseribili solo a fine crociera
		 * </p>
		 */
		f_blocco_ins_penale
	};
	
	/**
	 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcCrocieraTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcCrocieraTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCrocieraTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_CROCIERA}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcCrocieraTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}