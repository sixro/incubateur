
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_FORNITORE}.
 *
 * <p>
 * Elenco dei Fornitori MASS di Costa Crociere
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcFornitoreTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_fornitore";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_fornitore}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_fornitore}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_fornitore}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_FORNITORE}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code C_TIP_FORNITORE} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice della Tipologia di Azienda Fornitrice
		 * </p>
		 */
		c_tip_fornitore,

		/**
		 * Represents column {@code F_ONBEHALF} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag Onbehalf. Assume i valori Y/N. Ereditato da database MASS
		 * </p>
		 */
		f_onbehalf,

		/**
		 * Represents column {@code F_LOCAL} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag Local. Assume i valori Y/N. Ereditato da database MASS
		 * </p>
		 */
		f_local,

		/**
		 * Represents column {@code F_UNAT} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag UNAT. Assume i valori Y/N. Ereditato da database MASS, campo FLAGUNAT
		 * </p>
		 */
		f_unat,

		/**
		 * Represents column {@code F_CNSG_SETML} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Flag che indica se il Fornitore effettua consegne settimanali. Assume i valori Y/N. Ereditato da database MASS, campo WEEKDELIVERY
		 * </p>
		 */
		f_cnsg_setml,

		/**
		 * Represents column {@code C_ENT_BSNS_SOC_FORNITORE} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_soc_fornitore,

		/**
		 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice univoco a livello di Sistema dell'Entita' di Business.
		 * </p>
		 */
		c_ent_bsns_valuta,

		/**
		 * Represents column {@code C_CLSF_MERG} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice interno della classificazione merceologica
		 * </p>
		 */
		c_clsf_merg,

		/**
		 * Represents column {@code A_STATO} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Codice dello Stato
		 * </p>
		 */
		a_stato,

		/**
		 * Represents column {@code C_TIP_PRDT} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Chiave interna della categoria di prodotto
		 * </p>
		 */
		c_tip_prdt,

		/**
		 * Represents column {@code F_IBAN} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * vale 'Y' se la country del fornitore aderisce al circuito IBAN
		 * </p>
		 */
		f_iban,

		/**
		 * Represents column {@code F_UE} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Vale 'Y' se la country del fornitore appartiene all'Unione Europea
		 * </p>
		 */
		f_ue,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		v_ver,

		/**
		 * Represents column {@code C_COMPAGNIA} of table {@code CDC_FORNITORE}.
		 *
		 * <p>
		 * Idenitificatore univoco compagnia (FK)
		 * </p>
		 */
		c_compagnia
	};
	
	/**
	 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcFornitoreTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcFornitoreTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcFornitoreTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcFornitoreTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_FORNITORE}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcFornitoreTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}