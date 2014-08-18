
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_BAN_APGG_FORNITORE}.
 *
 * <p>
 * Banca di appoggio del Fornitore.
E' stata accantonata l'idea di strutturare le banche in una tabella CDC_BAN_APGG (Banca di appoggio) dove sarebbero finiti i codici univoci delle banche, associandola poi ai Fornitori con questa tabella associativa CDC_BAN_APGG_FORNITORE dove ad ogni fornitore venissero legati gli n possibili rapporti bancari (comprensivi di numero di CC).
Vista la eterogeneità e non coerenza dei dati provenienti dal sistema fonte, si sceglie di mettere tutti i dati relativi alle banche in questa tabella (che mantiene il nome di una associativa, come se la CDC_BAN_APGG esistesse davvero) dove ad ogni Fornitore potranno sì corrispondere più record, e dove tutti i dati della banca sono spalmati senza strutturazione.

 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcBanApggFornitoreTable {

	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE_NAME = "cdc_ban_apgg_fornitore";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_ban_apgg_fornitore}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_ban_apgg_fornitore}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_ban_apgg_fornitore}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
	
	/**
	 * Contains all columns found in table {@code CDC_BAN_APGG_FORNITORE}.
	 */
	public static enum Column {

		/**
		 * Represents column {@code F_PRIMARIA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Indica se si tratta della banca di appoggio primaria
		 * </p>
		 */
		f_primaria,

		/**
		 * Represents column {@code V_CC} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Numero di conto corrente
		 * </p>
		 */
		v_cc,

		/**
		 * Represents column {@code C_ENT_BSNS_SOC_FORNITORE} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice fornitore
		 * </p>
		 */
		c_ent_bsns_soc_fornitore,

		/**
		 * Represents column {@code P_ORD} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Ordine del rapporto nella lista di rapporti per un fornitore
		 * </p>
		 */
		p_ord,

		/**
		 * Represents column {@code C_BAN_APGG_FORNITORE} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Chiave interna del rapporto bancario
		 * </p>
		 */
		c_ban_apgg_fornitore,

		/**
		 * Represents column {@code F_ITA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Indica se la banca/filiale sia Italiana o meno.
		 * </p>
		 */
		f_ita,

		/**
		 * Represents column {@code C_BAN_APGG} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice MASS della Banca/Filiale
		 * </p>
		 */
		c_ban_apgg,

		/**
		 * Represents column {@code N_BAN_APGG} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Nome della Banca/Filiale
		 * </p>
		 */
		n_ban_apgg,

		/**
		 * Represents column {@code C_ABI} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice ABI per le Banche italiane
		 * </p>
		 */
		c_abi,

		/**
		 * Represents column {@code C_CAB} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice CAB per le filiali italiane
		 * </p>
		 */
		c_cab,

		/**
		 * Represents column {@code C_SWIFT} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice internazionale Swift
		 * </p>
		 */
		c_swift,

		/**
		 * Represents column {@code C_ABA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice ABA
		 * </p>
		 */
		c_aba,

		/**
		 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice Valuta per la filiale/banca
		 * </p>
		 */
		c_ent_bsns_valuta,

		/**
		 * Represents column {@code C_IBAN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice IBAN della Banca
		 * </p>
		 */
		c_iban,

		/**
		 * Represents column {@code C_CIN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * Codice CIN della Banca
		 * </p>
		 */
		c_cin,

		/**
		 * Represents column {@code D_MDF} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_mdf,

		/**
		 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_mdf,

		/**
		 * Represents column {@code N_LOGIN_IN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		n_login_in,

		/**
		 * Represents column {@code D_INI} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_ini,

		/**
		 * Represents column {@code D_FIN} of table {@code CDC_BAN_APGG_FORNITORE}.
		 *
		 * <p>
		 * 
		 * </p>
		 */
		d_fin,

		/**
		 * Represents column {@code V_VER} of table {@code CDC_BAN_APGG_FORNITORE}.
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
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @return basic &quot;select&quot; {@code SQL} using only specified columns
	 */
	public static String newSelect(CdcBanApggFornitoreTable.Column[] columns) {
		return new StringBuilder("SELECT ")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(" FROM ")
			.append(TABLE_NAME)
			.toString();
	}

	/**
	 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @return &quot;insert&quot; {@code SQL} using specified columns.
	 */
	public static String newInsert(CdcBanApggFornitoreTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @return &quot;update&quot; {@code SQL} using specified columns.
	 */
	public static String newUpdate(CdcBanApggFornitoreTable.Column[] columns) {
		return new StringBuilder("UPDATE ")
			.append(TABLE_NAME)
			.append(" SET ")
			.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
			.toString();
	}
	
	/**
	 * Returns the names of specified columns.
	 *
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcBanApggFornitoreTable.Column[] columns) {
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
	 * @param columns an array of columns of table {@code CDC_BAN_APGG_FORNITORE}
	 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
	 * @return names of specified columns
	 */
	public static String[] namesOf(CdcBanApggFornitoreTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}