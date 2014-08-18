
package app.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents the database to use in the application.
 *
 * <p>
 * Here can be find all tables with related columns available to the application.
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class DB {

	/**
	 * Represents table {@code CDC_BANCHINA}.
	 *
	 * <p>
	 * Elenco delle Banchine  associate al Porto
	 * </p>
	 */
	public static class cdc_banchina {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_banchina";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_banchina}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_banchina}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_banchina}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_BANCHINA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code S_BANCHINA} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * Descrizione banchina
			 * </p>
			 */
			s_banchina,

			/**
			 * Represents column {@code G_BANCHINA} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * Sigla mnemonica banchina
			 * </p>
			 */
			g_banchina,

			/**
			 * Represents column {@code C_ENT_BSNS_PORTO} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * Codice Porto
			 * </p>
			 */
			c_ent_bsns_porto,

			/**
			 * Represents column {@code C_BANCHINA} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * Codice interno banchina
			 * </p>
			 */
			c_banchina,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_BANCHINA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_BANCHINA}.
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
		 * @param columns an array of columns of table {@code CDC_BANCHINA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_banchina.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_BANCHINA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_banchina.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_BANCHINA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_banchina.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_BANCHINA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_banchina.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_BANCHINA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_banchina.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_BAN_APGG_FORNITORE}.
	 *
	 * <p>
	 * Banca di appoggio del Fornitore.
E' stata accantonata l'idea di strutturare le banche in una tabella CDC_BAN_APGG (Banca di appoggio) dove sarebbero finiti i codici univoci delle banche, associandola poi ai Fornitori con questa tabella associativa CDC_BAN_APGG_FORNITORE dove ad ogni fornitore venissero legati gli n possibili rapporti bancari (comprensivi di numero di CC).
Vista la eterogeneità e non coerenza dei dati provenienti dal sistema fonte, si sceglie di mettere tutti i dati relativi alle banche in questa tabella (che mantiene il nome di una associativa, come se la CDC_BAN_APGG esistesse davvero) dove ad ogni Fornitore potranno sì corrispondere più record, e dove tutti i dati della banca sono spalmati senza strutturazione.

	 * </p>
	 */
	public static class cdc_ban_apgg_fornitore {

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
		public static String newSelect(cdc_ban_apgg_fornitore.Column[] columns) {
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
		public static String newInsert(cdc_ban_apgg_fornitore.Column[] columns) {
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
		public static String newUpdate(cdc_ban_apgg_fornitore.Column[] columns) {
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
		public static String[] namesOf(cdc_ban_apgg_fornitore.Column[] columns) {
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
		public static String[] namesOf(cdc_ban_apgg_fornitore.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_CAMBIO}.
	 *
	 * <p>
	 * Valori dei tassi do conversione tra le monete censite in CDC_VALUTA. I cambi sono legati al Deployment per il quale valgono. All'interno del singolo Deployment, poi, c'è un ulteriore suddivisione in periodi individuata in tabella dal valore del campo G_PERIODO.
Per ogni valuta di partenza (C_ENT_BSNS_VALUTA_DA) il valore del tasso di cdambio V_CAMBIO indica il fattore per cui moltiplicarla per ottenere la conversione nella valuta di destinazione (C_ENT_BSNS_VALUTA_A)

	 * </p>
	 */
	public static class cdc_cambio {

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
		public static String newSelect(cdc_cambio.Column[] columns) {
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
		public static String newInsert(cdc_cambio.Column[] columns) {
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
		public static String newUpdate(cdc_cambio.Column[] columns) {
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
		public static String[] namesOf(cdc_cambio.Column[] columns) {
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
		public static String[] namesOf(cdc_cambio.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_CAMBIO_REUTERS}.
	 *
	 * <p>
	 * Valore dei tassi di conversione reuters
	 * </p>
	 */
	public static class cdc_cambio_reuters {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_cambio_reuters";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_cambio_reuters}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_cambio_reuters}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_cambio_reuters}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_CAMBIO_REUTERS}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code D_VAL} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * Data di validita' del cambio
			 * </p>
			 */
			d_val,

			/**
			 * Represents column {@code G_CAMBIO_REUTERS} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * Sigla Reutes che indica le due valute coinvolte nel cambio seguite dalla stringa FIX.  Ad. es: MTLAEDFIX
			 * </p>
			 */
			g_cambio_reuters,

			/**
			 * Represents column {@code V_CAMBIO_REUTERS} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * Tasso di Cambio per il giorno D_VAL
			 * </p>
			 */
			v_cambio_reuters,

			/**
			 * Represents column {@code C_ENT_BSNS_VALUTA_A} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * Valuta destinazione

			 * </p>
			 */
			c_ent_bsns_valuta_a,

			/**
			 * Represents column {@code C_ENT_BSNS_VALUTA_DA} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * Valuta fonte

			 * </p>
			 */
			c_ent_bsns_valuta_da,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_CAMBIO_REUTERS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_CAMBIO_REUTERS}.
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
		 * @param columns an array of columns of table {@code CDC_CAMBIO_REUTERS}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_cambio_reuters.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CAMBIO_REUTERS}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_cambio_reuters.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_CAMBIO_REUTERS}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_cambio_reuters.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CAMBIO_REUTERS}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_cambio_reuters.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_CAMBIO_REUTERS}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_cambio_reuters.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_CANALE_VENDITA}.
	 *
	 * <p>
	 * Elenco dei canali di vendita
	 * </p>
	 */
	public static class cdc_canale_vendita {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_canale_vendita";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_canale_vendita}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_canale_vendita}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_canale_vendita}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_CANALE_VENDITA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_CANALE_VENDITA} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Identificatore univoco
			 * </p>
			 */
			c_canale_vendita,

			/**
			 * Represents column {@code N_CANALE_VENDITA} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Nome canale di vendita
			 * </p>
			 */
			n_canale_vendita,

			/**
			 * Represents column {@code S_CANALE_VENDITA} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Descrizione canale
			 * </p>
			 */
			s_canale_vendita,

			/**
			 * Represents column {@code F_DEFAULT} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Se a Y indica il canale di default
			 * </p>
			 */
			f_default,

			/**
			 * Represents column {@code ORDINAMENTO} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Progressivo per ordinamento canali negli elenchi
			 * </p>
			 */
			ordinamento,

			/**
			 * Represents column {@code S_TIPOLOGIA} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Tipologia canale (BORDO/WEB)
			 * </p>
			 */
			s_tipologia,

			/**
			 * Represents column {@code S_ID_EXPORT} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Identificativo che distingue i vari file di export
			 * </p>
			 */
			s_id_export,

			/**
			 * Represents column {@code S_TIPO_RECORD_EXPORT} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Tipo record usato negli export per identificare i prezzi di vendita
			 * </p>
			 */
			s_tipo_record_export,

			/**
			 * Represents column {@code F_PRZ_MODIFICABILE} of table {@code CDC_CANALE_VENDITA}.
			 *
			 * <p>
			 * Se a Y indica che i prezzi associati al canale non sono modificabili da frontend
			 * </p>
			 */
			f_prz_modificabile
		};
		
		/**
		 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CANALE_VENDITA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_canale_vendita.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CANALE_VENDITA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_canale_vendita.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_CANALE_VENDITA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_canale_vendita.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CANALE_VENDITA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_canale_vendita.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_CANALE_VENDITA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_canale_vendita.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_CLSF_MERG}.
	 *
	 * <p>
	 * Elenco delle combinazioni Categoria e Classe merceologica dei vari prodotti/servizi così come censita su MASS.
Data la non coerente distribuzione dei dati su MASS (le stesse Classi sono spesso associate a Categorie diverse) e vista la responsabilita' del dato che spetta a MASS, non si creano tipologie gerarchiche per descrivere l'albero merceologico, ma si importano i dati così come sono su questa tabella.
	 * </p>
	 */
	public static class cdc_clsf_merg {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_clsf_merg";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_clsf_merg}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_clsf_merg}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_clsf_merg}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_CLSF_MERG}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_CATEG_MERG} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * Codice Categoria merceologica (da MASS)
			 * </p>
			 */
			c_categ_merg,

			/**
			 * Represents column {@code C_CLAS_MERG} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * Codice della Classe merceologica
			 * </p>
			 */
			c_clas_merg,

			/**
			 * Represents column {@code C_CLSF_MERG} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * Codice interno della classificazione merceologica
			 * </p>
			 */
			c_clsf_merg,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_CLSF_MERG}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_CLSF_MERG}.
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
		 * @param columns an array of columns of table {@code CDC_CLSF_MERG}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_clsf_merg.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CLSF_MERG}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_clsf_merg.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_CLSF_MERG}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_clsf_merg.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_CLSF_MERG}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_clsf_merg.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_CLSF_MERG}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_clsf_merg.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_COMPAGNIA}.
	 *
	 * <p>
	 * Contiene i codici ed i nomi delle compagnie legate a Costa Crociere. Ogni nave e' legata ad una compagnia (vedi cdc_nave.c_compagnia)
	 * </p>
	 */
	public static class cdc_compagnia {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_compagnia";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_compagnia}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_compagnia}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_compagnia}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_COMPAGNIA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_COMPAGNIA} of table {@code CDC_COMPAGNIA}.
			 *
			 * <p>
			 * Codice Costa della compagnia
			 * </p>
			 */
			c_compagnia,

			/**
			 * Represents column {@code N_COMPAGNIA} of table {@code CDC_COMPAGNIA}.
			 *
			 * <p>
			 * Nome della compagnia
			 * </p>
			 */
			n_compagnia,

			/**
			 * Represents column {@code DWH_COMPANY_CODE} of table {@code CDC_COMPAGNIA}.
			 *
			 * <p>
			 * Codice univoco compagnia nel DWH
			 * </p>
			 */
			dwh_company_code
		};
		
		/**
		 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_compagnia.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_compagnia.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_compagnia.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_compagnia.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_COMPAGNIA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_compagnia.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_COMPETENZA_CROCIERA}.
	 *
	 * <p>
	 * Riferimenti ai mesi contabili di competenza della Crociera.
	 * </p>
	 */
	public static class cdc_competenza_crociera {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_competenza_crociera";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_competenza_crociera}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_competenza_crociera}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_competenza_crociera}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_COMPETENZA_CROCIERA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code D_MESE_CPTN} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * Mese di competenza all'interno dell'anno fiscale
			 * </p>
			 */
			d_mese_cptn,

			/**
			 * Represents column {@code D_MESE_COMLE} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * Mese di competenza commerciale all'interno dell'anno fiscale
			 * </p>
			 */
			d_mese_comle,

			/**
			 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_crociera,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_COMPETENZA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_COMPETENZA_CROCIERA}.
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
		 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_competenza_crociera.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_competenza_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_competenza_crociera.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_competenza_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_COMPETENZA_CROCIERA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_competenza_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_CROCIERA}.
	 *
	 * <p>
	 * Censimento crociera associa nave ad una data di inzio e fine navigazione
	 * </p>
	 */
	public static class cdc_crociera {

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
		public static String newSelect(cdc_crociera.Column[] columns) {
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
		public static String newInsert(cdc_crociera.Column[] columns) {
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
		public static String newUpdate(cdc_crociera.Column[] columns) {
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
		public static String[] namesOf(cdc_crociera.Column[] columns) {
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
		public static String[] namesOf(cdc_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_DEPLOYMENT}.
	 *
	 * <p>
	 * Tabella che riporta I Deployment Costa (coppie "Anno/Tipo Deployment") che si associano a Crociere e Cambi delle valute per sapere se si riferiscono allo schedule correntemente approvato (Consuntivo) piuttosto che a Budget o Forecast.
	 * </p>
	 */
	public static class cdc_deployment {

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
		public static String newSelect(cdc_deployment.Column[] columns) {
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
		public static String newInsert(cdc_deployment.Column[] columns) {
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
		public static String newUpdate(cdc_deployment.Column[] columns) {
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
		public static String[] namesOf(cdc_deployment.Column[] columns) {
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
		public static String[] namesOf(cdc_deployment.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_DPT_FORNITORE}.
	 *
	 * <p>
	 * Associa ciascun Fornitore ai Dipartimenti Costa che hanno a che fare con lui.
	 * </p>
	 */
	public static class cdc_dpt_fornitore {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_dpt_fornitore";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_dpt_fornitore}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_dpt_fornitore}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_dpt_fornitore}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_DPT_FORNITORE}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_ENT_BSNS_SOC_FORNITORE} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * Codice del fornitore
			 * </p>
			 */
			c_ent_bsns_soc_fornitore,

			/**
			 * Represents column {@code C_ENT_BSNS_DPT} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * Codice del Dipartimento Costa
			 * </p>
			 */
			c_ent_bsns_dpt,

			/**
			 * Represents column {@code F_PRIMARIO} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * Flag indicante se il Dipartimento è prevalente per il Fornitore
			 * </p>
			 */
			f_primario,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_DPT_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_DPT_FORNITORE}.
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
		 * @param columns an array of columns of table {@code CDC_DPT_FORNITORE}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_dpt_fornitore.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_DPT_FORNITORE}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_dpt_fornitore.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_DPT_FORNITORE}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_dpt_fornitore.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_DPT_FORNITORE}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_dpt_fornitore.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_DPT_FORNITORE}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_dpt_fornitore.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_FORNITORE}.
	 *
	 * <p>
	 * Elenco dei Fornitori MASS di Costa Crociere
	 * </p>
	 */
	public static class cdc_fornitore {

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
		public static String newSelect(cdc_fornitore.Column[] columns) {
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
		public static String newInsert(cdc_fornitore.Column[] columns) {
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
		public static String newUpdate(cdc_fornitore.Column[] columns) {
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
		public static String[] namesOf(cdc_fornitore.Column[] columns) {
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
		public static String[] namesOf(cdc_fornitore.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_FSTVT}.
	 *
	 * <p>
	 * Tabella anagrafica per il censimento delle festivita
	 * </p>
	 */
	public static class cdc_fstvt {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_fstvt";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_fstvt}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_fstvt}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_fstvt}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_FSTVT}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_FSTVT} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * Codice Festività
			 * </p>
			 */
			c_fstvt,

			/**
			 * Represents column {@code N_FSTVT} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * Nome della Festivita
			 * </p>
			 */
			n_fstvt,

			/**
			 * Represents column {@code C_TIP_FSTVT} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			c_tip_fstvt,

			/**
			 * Represents column {@code F_RICORR} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * Flag che indica se la festività si ripete nello stesso giorno ogni anno.
			 * </p>
			 */
			f_ricorr,

			/**
			 * Represents column {@code D_FIN_FSTVT} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * Fine del periodo di festività. Può essere nullo se la festività è un giorno singolo.
			 * </p>
			 */
			d_fin_fstvt,

			/**
			 * Represents column {@code D_INI_FSTVT} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * Inizio del periodo di festività
			 * </p>
			 */
			d_ini_fstvt,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_FSTVT}.
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
		 * @param columns an array of columns of table {@code CDC_FSTVT}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_fstvt.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_FSTVT}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_fstvt.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_FSTVT}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_fstvt.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_FSTVT}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_fstvt.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_FSTVT}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_fstvt.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_FSTVT_ENT_BSNS}.
	 *
	 * <p>
	 * Elenca i giorni di festivita' per le Entità di Business.
Diverse Entità possono avere entry in questa tabella:
Aree Geografiche (Paesi)
Porti
Tour Operator

	 * </p>
	 */
	public static class cdc_fstvt_ent_bsns {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_fstvt_ent_bsns";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_fstvt_ent_bsns}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_fstvt_ent_bsns}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_fstvt_ent_bsns}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_FSTVT_ENT_BSNS}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_ENT_BSNS} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns,

			/**
			 * Represents column {@code X_NOTE_FSTVT} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * Eventuali note legate alla festivita per la specifica Entity
			 * </p>
			 */
			x_note_fstvt,

			/**
			 * Represents column {@code C_FSTVT} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * Codice Festività
			 * </p>
			 */
			c_fstvt,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_FSTVT_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_FSTVT_ENT_BSNS}.
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
		 * @param columns an array of columns of table {@code CDC_FSTVT_ENT_BSNS}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_fstvt_ent_bsns.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_FSTVT_ENT_BSNS}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_fstvt_ent_bsns.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_FSTVT_ENT_BSNS}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_fstvt_ent_bsns.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_FSTVT_ENT_BSNS}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_fstvt_ent_bsns.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_FSTVT_ENT_BSNS}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_fstvt_ent_bsns.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_GIORN_CALEN}.
	 *
	 * <p>
	 * Enumera i giorni della settimana.
Tale numerazione viene utilizzata per indicare le date ricorrenti, quali ad es. i giorni infrasettimanali di chiusura.
	 * </p>
	 */
	public static class cdc_giorn_calen {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_giorn_calen";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_giorn_calen}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_giorn_calen}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_giorn_calen}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_GIORN_CALEN}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_GIORN_CALEN} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * Codice del giorno
			 * </p>
			 */
			c_giorn_calen,

			/**
			 * Represents column {@code N_GIORN_CALEN} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * Nome del giorno. Comprende sia i giorni della settimana che categorie piu' "estese" come:
 - tutti
 - nessuno
 - feriale
 - festivo

			 * </p>
			 */
			n_giorn_calen,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_GIORN_CALEN}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_GIORN_CALEN}.
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
		 * @param columns an array of columns of table {@code CDC_GIORN_CALEN}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_giorn_calen.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_GIORN_CALEN}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_giorn_calen.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_GIORN_CALEN}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_giorn_calen.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_GIORN_CALEN}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_giorn_calen.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_GIORN_CALEN}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_giorn_calen.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
	 *
	 * <p>
	 * Giorno di chiusura settimanale per l'Entità di Business
	 * </p>
	 */
	public static class cdc_giorn_chius_ent_bsns {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_giorn_chius_ent_bsns";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_giorn_chius_ent_bsns}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_giorn_chius_ent_bsns}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_giorn_chius_ent_bsns}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_ENT_BSNS} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns,

			/**
			 * Represents column {@code C_GIORN_CALEN} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * Codice del giorno
			 * </p>
			 */
			c_giorn_calen,

			/**
			 * Represents column {@code D_INI_VAL} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * Inizio del periodo di validita' del giorno di chiusura
			 * </p>
			 */
			d_ini_val,

			/**
			 * Represents column {@code D_FIN_VAL} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * Fine del periodo di validità del giorno di chiusura
			 * </p>
			 */
			d_fin_val,

			/**
			 * Represents column {@code F_RICORR_ANN} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * Flag di ricorrenza annuale. Se valorizzato a 'S', il giorno di chiusura con il periodo di validità indicato si ripete ogni anno.
			 * </p>
			 */
			f_ricorr_ann,

			/**
			 * Represents column {@code X_NOT} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * Eventuali note legate al periodo/giorno di chiusura
			 * </p>
			 */
			x_not,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_GIORN_CHIUS_ENT_BSNS}.
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
		 * @param columns an array of columns of table {@code CDC_GIORN_CHIUS_ENT_BSNS}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_giorn_chius_ent_bsns.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_GIORN_CHIUS_ENT_BSNS}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_giorn_chius_ent_bsns.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_GIORN_CHIUS_ENT_BSNS}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_giorn_chius_ent_bsns.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_GIORN_CHIUS_ENT_BSNS}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_giorn_chius_ent_bsns.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_GIORN_CHIUS_ENT_BSNS}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_giorn_chius_ent_bsns.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_HMS_APER_ENT_BSNS}.
	 *
	 * <p>
	 * Orari di apertura di un Entità di Business per cui si applicano degli orari di apertura/disponibilità.
Ogni Entità qui presente può avere più record, ciascuno indicante l'orario di apertura per il periodo di validità (ad es aperture stagionali con orari diversi)
	 * </p>
	 */
	public static class cdc_hms_aper_ent_bsns {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_hms_aper_ent_bsns";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_hms_aper_ent_bsns}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_hms_aper_ent_bsns}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_hms_aper_ent_bsns}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_HMS_APER_ENT_BSNS}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_ENT_BSNS} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns,

			/**
			 * Represents column {@code C_GIORN_CALEN} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Codice del giorno della settimana cui si applica l'orario. Obbligatorio, può valere 'tutti' se copre l'intera settiamna.
			 * </p>
			 */
			c_giorn_calen,

			/**
			 * Represents column {@code D_INI_VAL} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Inizio del periodo di validita' durante il quale si applica l'orario specificato in questo record
			 * </p>
			 */
			d_ini_val,

			/**
			 * Represents column {@code D_FIN_VAL} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Fine del periodo di validita' durante il quale si applica l'orario specificato in questo record
			 * </p>
			 */
			d_fin_val,

			/**
			 * Represents column {@code H_APER_DA} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Orario di apertura (numerico. Es: 930 per 09:30, 1930 per 19:30)
			 * </p>
			 */
			h_aper_da,

			/**
			 * Represents column {@code H_APER_A} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Orario di chiusura
			 * </p>
			 */
			h_aper_a,

			/**
			 * Represents column {@code F_RICORR_ANN} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Flag di ricorrenza annuale. Se valorizzato a 'S', il periodo di validità dell'orario di apertura si ripete ogni anno.
			 * </p>
			 */
			f_ricorr_ann,

			/**
			 * Represents column {@code X_NOT} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * Eventuali note legate all'orario di apertura
			 * </p>
			 */
			x_not,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_HMS_APER_ENT_BSNS}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_HMS_APER_ENT_BSNS}.
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
		 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_hms_aper_ent_bsns.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_hms_aper_ent_bsns.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_hms_aper_ent_bsns.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_hms_aper_ent_bsns.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_HMS_APER_ENT_BSNS}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_hms_aper_ent_bsns.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_NAVE}.
	 *
	 * <p>
	 * Elenco delle Navi della flotta Costa
	 * </p>
	 */
	public static class cdc_nave {

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
		public static String newSelect(cdc_nave.Column[] columns) {
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
		public static String newInsert(cdc_nave.Column[] columns) {
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
		public static String newUpdate(cdc_nave.Column[] columns) {
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
		public static String[] namesOf(cdc_nave.Column[] columns) {
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
		public static String[] namesOf(cdc_nave.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_PARM_PAGM}.
	 *
	 * <p>
	 * Ogni record raggruppa l'insieme delle condizioni di pagamento cui e' associato il Fornitore
	 * </p>
	 */
	public static class cdc_parm_pagm {

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
		public static String newSelect(cdc_parm_pagm.Column[] columns) {
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
		public static String newInsert(cdc_parm_pagm.Column[] columns) {
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
		public static String newUpdate(cdc_parm_pagm.Column[] columns) {
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
		public static String[] namesOf(cdc_parm_pagm.Column[] columns) {
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
		public static String[] namesOf(cdc_parm_pagm.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_PIANO_CROCIERA}.
	 *
	 * <p>
	 * Ogni crociera ha associato un piano valido. Il piano riporta il tragitto effettuato dalla Nave. Il dettaglio del Piano è costituito da una lista di "tratte" (navigazione e scali nei porti) riportato in tabella CDC_TRATTA_CROCIERA.
Tabella che eredita i valori da EASY (tabella SCALO)

	 * </p>
	 */
	public static class cdc_piano_crociera {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_piano_crociera";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_piano_crociera}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_piano_crociera}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_piano_crociera}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_PIANO_CROCIERA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_PIANO_CROCIERA} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * Codice univoco (da sequence) della tratta di crociera
			 * </p>
			 */
			c_piano_crociera,

			/**
			 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_crociera,

			/**
			 * Represents column {@code A_STATO} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * Codice dello stato del piano crociera. null indica che il piano crociera e' in attesa di elaborazione
			 * </p>
			 */
			a_stato,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			v_ver,

			/**
			 * Represents column {@code PIANO_MANUALE} of table {@code CDC_PIANO_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			piano_manuale
		};
		
		/**
		 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_piano_crociera.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_piano_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_piano_crociera.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_piano_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_PIANO_CROCIERA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_piano_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_PORTO}.
	 *
	 * <p>
	 * Tabella anagrafica per il censimento dei porti
	 * </p>
	 */
	public static class cdc_porto {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_porto";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_porto}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_porto}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_porto}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_PORTO}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code G_PORTO} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * Codifica Costa del porto
			 * </p>
			 */
			g_porto,

			/**
			 * Represents column {@code N_PORTO} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_porto,

			/**
			 * Represents column {@code S_PORTO} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			s_porto,

			/**
			 * Represents column {@code C_ENT_BSNS_PORTO} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_porto,

			/**
			 * Represents column {@code A_STATO} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * Codice dello Stato
			 * </p>
			 */
			a_stato,

			/**
			 * Represents column {@code F_NASCONDI_INTRANET} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			f_nascondi_intranet,

			/**
			 * Represents column {@code C_ENT_BSNS_AREA_GEOGR_AREA} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_area_geogr_area,

			/**
			 * Represents column {@code C_ENT_BSNS_AREA_GEOGR_PAESE} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_area_geogr_paese,

			/**
			 * Represents column {@code C_ENT_BSNS_AREA_GEOGR_CITTA} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_area_geogr_citta,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			v_ver,

			/**
			 * Represents column {@code UN_LOCATION_CODE} of table {@code CDC_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			un_location_code
		};
		
		/**
		 * Returns a basic &quot;select&quot; {@code SQL} using only specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_PORTO}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_porto.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_PORTO}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_porto.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_PORTO}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_porto.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_PORTO}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_porto.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_PORTO}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_porto.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_COND_PAGM}.
	 *
	 * <p>
	 * Tipi di Condizioni di Pagamento
	 * </p>
	 */
	public static class cdc_tip_cond_pagm {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_cond_pagm";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_cond_pagm}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_cond_pagm}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_cond_pagm}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_COND_PAGM}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_COND_PAGM} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * Codice Condizione di pagamento
			 * </p>
			 */
			c_tip_cond_pagm,

			/**
			 * Represents column {@code N_TIP_COND_PAGM} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * DEscrizione della condizione di pagamento
			 * </p>
			 */
			n_tip_cond_pagm,

			/**
			 * Represents column {@code G_TIP_COND_PAGM} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * Codice Costa della Condizione di pagamento (ereditato da MASS)
			 * </p>
			 */
			g_tip_cond_pagm,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_COND_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_COND_PAGM}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_COND_PAGM}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_cond_pagm.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_COND_PAGM}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_cond_pagm.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_COND_PAGM}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_cond_pagm.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_COND_PAGM}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_cond_pagm.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_COND_PAGM}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_cond_pagm.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_CROCIERA}.
	 *
	 * <p>
	 * Tipizza le Crociere. I valori sono ereditati da EASY e sono solo C, S, N
	 * </p>
	 */
	public static class cdc_tip_crociera {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_crociera";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_crociera}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_crociera}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_crociera}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_CROCIERA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_CROCIERA} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * Codice tipo crociera
			 * </p>
			 */
			c_tip_crociera,

			/**
			 * Represents column {@code S_TIP_CROCIERA} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * Descrizione Tipo Crociera
			 * </p>
			 */
			s_tip_crociera,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_CROCIERA}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_CROCIERA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_crociera.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_CROCIERA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_CROCIERA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_crociera.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_CROCIERA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_CROCIERA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_FORNITORE}.
	 *
	 * <p>
	 * Elenco delle tipologie di Azienda Fornitrice Costa.
E' un valore ereditato da MASS e vale solo:  P,  C,  NP

	 * </p>
	 */
	public static class cdc_tip_fornitore {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_fornitore";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_fornitore}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_fornitore}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_fornitore}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_FORNITORE}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_FORNITORE} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * Codice della Tipologia di Azienda Fornitrice
			 * </p>
			 */
			c_tip_fornitore,

			/**
			 * Represents column {@code S_TIP_FORNITORE} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * Descrizione della Tipologia di Azienda Fornitrice
			 * </p>
			 */
			s_tip_fornitore,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_FORNITORE}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_FORNITORE}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_FORNITORE}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_fornitore.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_FORNITORE}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_fornitore.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_FORNITORE}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_fornitore.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_FORNITORE}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_fornitore.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_FORNITORE}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_fornitore.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_FSTVT}.
	 *
	 * <p>
	 * Censisce le tipologie di festivita':
 - festività civile
 - festività religiosa
 - festività patronale
 - ...
	 * </p>
	 */
	public static class cdc_tip_fstvt {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_fstvt";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_fstvt}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_fstvt}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_fstvt}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_FSTVT}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_FSTVT} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			c_tip_fstvt,

			/**
			 * Represents column {@code S_TIP_FSTVT} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * Descrizione del tipo Festivita
			 * </p>
			 */
			s_tip_fstvt,

			/**
			 * Represents column {@code G_TIP_FSTVT} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * Mnemonico del tipo frestivita'
			 * </p>
			 */
			g_tip_fstvt,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_FSTVT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_FSTVT}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_FSTVT}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_fstvt.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_FSTVT}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_fstvt.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_FSTVT}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_fstvt.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_FSTVT}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_fstvt.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_FSTVT}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_fstvt.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_GRP_PAGM}.
	 *
	 * <p>
	 * Tipi di Gruppi di Pagamento
	 * </p>
	 */
	public static class cdc_tip_grp_pagm {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_grp_pagm";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_grp_pagm}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_grp_pagm}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_grp_pagm}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_GRP_PAGM}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_GRP_PAGM} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * Codice del Gruppo di pagamento
			 * </p>
			 */
			c_tip_grp_pagm,

			/**
			 * Represents column {@code G_TIP_GRP_PAGM} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * Codice Costa del Gruppo di pagamento
			 * </p>
			 */
			g_tip_grp_pagm,

			/**
			 * Represents column {@code S_TIP_GRP_PAGM} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * Descrizione del Gruppo di pagamento
			 * </p>
			 */
			s_tip_grp_pagm,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_GRP_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_GRP_PAGM}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_GRP_PAGM}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_grp_pagm.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_GRP_PAGM}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_grp_pagm.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_GRP_PAGM}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_grp_pagm.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_GRP_PAGM}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_grp_pagm.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_GRP_PAGM}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_grp_pagm.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_MOD_PAGM}.
	 *
	 * <p>
	 * Tipi di Modalità di Pagamento
	 * </p>
	 */
	public static class cdc_tip_mod_pagm {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_mod_pagm";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_mod_pagm}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_mod_pagm}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_mod_pagm}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_MOD_PAGM}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_MOD_PAGM} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * Codice Modalita di pagamento
			 * </p>
			 */
			c_tip_mod_pagm,

			/**
			 * Represents column {@code G_TIP_MOD_PAGM} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * Codice Costa della Modalita di pagamento (ereditato da MASS)
			 * </p>
			 */
			g_tip_mod_pagm,

			/**
			 * Represents column {@code S_TIP_MOD_PAGM} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * Descrizione della Modalita di pagamento
			 * </p>
			 */
			s_tip_mod_pagm,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_MOD_PAGM}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_MOD_PAGM}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_mod_pagm.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_mod_pagm.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_mod_pagm.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_mod_pagm.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_MOD_PAGM}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_mod_pagm.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_PRDT}.
	 *
	 * <p>
	 * Caratteristiche del prodotto che ciascun Fornitore offre a Costa.
Attualmente, per eredita' dal legacy MASS, ogni Fornitore ha un solo prodotto/categoria prodotto.
	 * </p>
	 */
	public static class cdc_tip_prdt {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_prdt";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_prdt}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_prdt}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_prdt}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_PRDT}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_PRDT} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * Chiave interna della categoria di prodotto
			 * </p>
			 */
			c_tip_prdt,

			/**
			 * Represents column {@code N_TIP_PRDT} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * Sigla (Codice Costa) della categoria di prodotto
			 * </p>
			 */
			n_tip_prdt,

			/**
			 * Represents column {@code S_TIP_PRDT} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * Descrizione della categoria di prodotto
			 * </p>
			 */
			s_tip_prdt,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_PRDT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_PRDT}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_PRDT}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_prdt.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_PRDT}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_prdt.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_PRDT}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_prdt.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_PRDT}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_prdt.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_PRDT}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_prdt.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
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
	 */
	public static class cdc_tip_stato {

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
		public static String newSelect(cdc_tip_stato.Column[] columns) {
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
		public static String newInsert(cdc_tip_stato.Column[] columns) {
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
		public static String newUpdate(cdc_tip_stato.Column[] columns) {
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
		public static String[] namesOf(cdc_tip_stato.Column[] columns) {
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
		public static String[] namesOf(cdc_tip_stato.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_TOLLN_FAT}.
	 *
	 * <p>
	 * Elenco delle categorie delle Tolleranze per le Fatture
	 * </p>
	 */
	public static class cdc_tip_tolln_fat {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_tolln_fat";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_tolln_fat}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_tolln_fat}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_tolln_fat}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_TOLLN_FAT}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_TOLLN_FAT} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * Codice interno del tipo di tolleranza
			 * </p>
			 */
			c_tip_tolln_fat,

			/**
			 * Represents column {@code G_TIP_TOLLN_FAT} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * Sigla del tipo di tolleranza (ereditata da MASS)
			 * </p>
			 */
			g_tip_tolln_fat,

			/**
			 * Represents column {@code S_TIP_TOLLN_FAT} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * Descrizione del tipo di tolleranza
			 * </p>
			 */
			s_tip_tolln_fat,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_TOLLN_FAT}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_TOLLN_FAT}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_TOLLN_FAT}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_tolln_fat.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_TOLLN_FAT}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_tolln_fat.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_TOLLN_FAT}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_tolln_fat.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_TOLLN_FAT}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_tolln_fat.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_TOLLN_FAT}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_tolln_fat.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TIP_TRATTA_CROCIERA}.
	 *
	 * <p>
	 * Elenca i tipi di tratte che possono comporre una Crociera
Censimento degli Stati di attraversamento di una determinata tratta del piano di Crociera.
Valori ammissibili:
- Partenza: inizio della Crociera
- Navigazione: la nave e' in navigazione (tra due fasi di Scalo o Partenza/Arrivo)
- Scalo: la Nave a' ferma in porto
- Arrivo: La nave arriva al Porto dove si conclude la Crociera
- Attracco: La nave arriva ad un Porto (termine tratta di Navigazione)
- Transito: la nave transita per uno stretto
	 * </p>
	 */
	public static class cdc_tip_tratta_crociera {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tip_tratta_crociera";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tip_tratta_crociera}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tip_tratta_crociera}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tip_tratta_crociera}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TIP_TRATTA_CROCIERA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TIP_TRATTA_CROCIERA} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * Codice del tipo di Stato di attraversamento di una determinata tratta del piano di Crociera.
Valori ammissibili:
  'P' - Partenza (inizio Crociera)
  'N' - Navigazione
  'S' - Scalo
  'D' - Arrivo (fine Crociera)
  'A' - Attracco
  'T' - Transito
			 * </p>
			 */
			c_tip_tratta_crociera,

			/**
			 * Represents column {@code S_TIP_TRATTA_CROCIERA} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * Descrizione dello stato
			 * </p>
			 */
			s_tip_tratta_crociera,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TIP_TRATTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TIP_TRATTA_CROCIERA}.
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
		 * @param columns an array of columns of table {@code CDC_TIP_TRATTA_CROCIERA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tip_tratta_crociera.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_TRATTA_CROCIERA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tip_tratta_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_TRATTA_CROCIERA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tip_tratta_crociera.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TIP_TRATTA_CROCIERA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_tratta_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TIP_TRATTA_CROCIERA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tip_tratta_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TMPT_PD}.
	 *
	 * <p>
	 * Template per periodi di tempo generici.
Serve ad alimentare, pur senza essere ad esse legata in alcun modo, con valori 'predefiniti' i periodi di apertura o chiusura di Entità di business.
Ogni record e' caratterizzato dalla coppia di date <da..a>
	 * </p>
	 */
	public static class cdc_tmpt_pd {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_tmpt_pd";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_tmpt_pd}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_tmpt_pd}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_tmpt_pd}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_TMPT_PD}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_TMPT_PD} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * Codice interno del Periodo
			 * </p>
			 */
			c_tmpt_pd,

			/**
			 * Represents column {@code D_VAL_PD_DA} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * Data inizio del Periodo
			 * </p>
			 */
			d_val_pd_da,

			/**
			 * Represents column {@code D_VAL_PD_A} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * Data fine del Periodo
			 * </p>
			 */
			d_val_pd_a,

			/**
			 * Represents column {@code N_TMPT_PD} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * Nome del periodo
			 * </p>
			 */
			n_tmpt_pd,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_TMPT_PD}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_TMPT_PD}.
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
		 * @param columns an array of columns of table {@code CDC_TMPT_PD}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_tmpt_pd.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TMPT_PD}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_tmpt_pd.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TMPT_PD}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_tmpt_pd.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_TMPT_PD}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tmpt_pd.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_TMPT_PD}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_tmpt_pd.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_TRATTA_CROCIERA}.
	 *
	 * <p>
	 * Dettaglio di un Piano Crociera. Elenca il percorso della Nave nei giorni di crociera distinguendo navigazione da scali nei porti.
	 * </p>
	 */
	public static class cdc_tratta_crociera {

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
		public static String newSelect(cdc_tratta_crociera.Column[] columns) {
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
		public static String newInsert(cdc_tratta_crociera.Column[] columns) {
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
		public static String newUpdate(cdc_tratta_crociera.Column[] columns) {
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
		public static String[] namesOf(cdc_tratta_crociera.Column[] columns) {
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
		public static String[] namesOf(cdc_tratta_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_VALUTA}.
	 *
	 * <p>
	 * Elenco delle Valute mondiali censite in Costa
	 * </p>
	 */
	public static class cdc_valuta {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_valuta";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_valuta}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_valuta}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_valuta}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_VALUTA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code S_VALUTA} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * Descrizione valuta
			 * </p>
			 */
			s_valuta,

			/**
			 * Represents column {@code I_COEFF} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * Coefficiente rispetto a ??
			 * </p>
			 */
			i_coeff,

			/**
			 * Represents column {@code Q_DECIMALI} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * Numero di decimali con cui si esprimono le cifre in valuta
			 * </p>
			 */
			q_decimali,

			/**
			 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_valuta,

			/**
			 * Represents column {@code A_STATO} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * Codice dello Stato
			 * </p>
			 */
			a_stato,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_VALUTA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_VALUTA}.
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
		 * @param columns an array of columns of table {@code CDC_VALUTA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_valuta.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_valuta.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_valuta.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_VALUTA_CROCIERA}.
	 *
	 * <p>
	 * Elenco valute con cui si possono effettuare i pagamenti a bordo
	 * </p>
	 */
	public static class cdc_valuta_crociera {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_valuta_crociera";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_valuta_crociera}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_valuta_crociera}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_valuta_crociera}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_VALUTA_CROCIERA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_VALUTA_CROCIERA} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			c_valuta_crociera,

			/**
			 * Represents column {@code F_VALUTA_SAPI} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * Indica se la valuta proviene da SAPI. Dato Legacy
			 * </p>
			 */
			f_valuta_sapi,

			/**
			 * Represents column {@code C_ENT_BSNS_CROCIERA} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_crociera,

			/**
			 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_valuta,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_VALUTA_CROCIERA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_VALUTA_CROCIERA}.
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_CROCIERA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_valuta_crociera.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA_CROCIERA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_valuta_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_CROCIERA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_valuta_crociera.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA_CROCIERA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta_crociera.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_CROCIERA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta_crociera.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_VALUTA_PORTO}.
	 *
	 * <p>
	 * Elenco valute assciate al Porto
	 * </p>
	 */
	public static class cdc_valuta_porto {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_valuta_porto";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_valuta_porto}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_valuta_porto}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_valuta_porto}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_VALUTA_PORTO}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_VALUTA_PORTO} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			c_valuta_porto,

			/**
			 * Represents column {@code F_PRINCIPALE} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			f_principale,

			/**
			 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_valuta,

			/**
			 * Represents column {@code C_ENT_BSNS_PORTO} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_porto,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_VALUTA_PORTO}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_VALUTA_PORTO}.
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_PORTO}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_valuta_porto.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA_PORTO}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_valuta_porto.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_PORTO}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_valuta_porto.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA_PORTO}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta_porto.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_PORTO}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta_porto.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code CDC_VALUTA_VENDITA}.
	 *
	 * <p>
	 * Elenco delle valute con cui le Escursioni in generale possono essere vendute a bordo.
Si tratta di un sottoinsieme di CDC_VALUTA e al momento contiene solo EUR e USD. Le valute accettabili per l'acquisto di ogni singola escursione e' contenuto in CDE_VALUTA_ESCURSIONE

	 * </p>
	 */
	public static class cdc_valuta_vendita {

		/**
		 * Contains the name of the table.
		 *
		 * <p>
		 * Can be used to format others {@code SQL}.
		 * </p>
		 */		
		public static final String TABLE_NAME = "cdc_valuta_vendita";
		
		/**
		 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_valuta_vendita}.
		 */		
		public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code SELECT * FROM cdc_valuta_vendita}.
		 */		
		public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

		/**
		 * Contains a preformatted {@code DELETE FROM cdc_valuta_vendita}.
		 */		
		public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME;
		
		/**
		 * Contains all columns found in table {@code CDC_VALUTA_VENDITA}.
		 */
		public static enum Column {

			/**
			 * Represents column {@code C_ENT_BSNS_VALUTA} of table {@code CDC_VALUTA_VENDITA}.
			 *
			 * <p>
			 * Codice univoco a livello di Sistema dell'Entita' di Business.
			 * </p>
			 */
			c_ent_bsns_valuta,

			/**
			 * Represents column {@code D_MDF} of table {@code CDC_VALUTA_VENDITA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_mdf,

			/**
			 * Represents column {@code N_LOGIN_MDF} of table {@code CDC_VALUTA_VENDITA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_mdf,

			/**
			 * Represents column {@code N_LOGIN_IN} of table {@code CDC_VALUTA_VENDITA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			n_login_in,

			/**
			 * Represents column {@code D_INI} of table {@code CDC_VALUTA_VENDITA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_ini,

			/**
			 * Represents column {@code D_FIN} of table {@code CDC_VALUTA_VENDITA}.
			 *
			 * <p>
			 * 
			 * </p>
			 */
			d_fin,

			/**
			 * Represents column {@code V_VER} of table {@code CDC_VALUTA_VENDITA}.
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_VENDITA}
		 * @return basic &quot;select&quot; {@code SQL} using only specified columns
		 */
		public static String newSelect(cdc_valuta_vendita.Column[] columns) {
			return new StringBuilder("SELECT ")
				.append(StringUtils.join(namesOf(columns), ", "))
				.append(" FROM ")
				.append(TABLE_NAME)
				.toString();
		}

		/**
		 * Returns an &quot;insert&quot; {@code SQL} using specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA_VENDITA}
		 * @return &quot;insert&quot; {@code SQL} using specified columns.
		 */
		public static String newInsert(cdc_valuta_vendita.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_VENDITA}
		 * @return &quot;update&quot; {@code SQL} using specified columns.
		 */
		public static String newUpdate(cdc_valuta_vendita.Column[] columns) {
			return new StringBuilder("UPDATE ")
				.append(TABLE_NAME)
				.append(" SET ")
				.append(StringUtils.join(namesOf(columns, "${name} = ?"), ", "))
				.toString();
		}
		
		/**
		 * Returns the names of specified columns.
		 *
		 * @param columns an array of columns of table {@code CDC_VALUTA_VENDITA}
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta_vendita.Column[] columns) {
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
		 * @param columns an array of columns of table {@code CDC_VALUTA_VENDITA}
		 * @param template a template ala {@link StrSubstitutor} of {@code commons-lang} library
		 * @return names of specified columns
		 */
		public static String[] namesOf(cdc_valuta_vendita.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	
	/**
	 * Represents table {@code ENT_BSNS}.
	 *
	 * <p>
	 * 
	 * </p>
	 */
	public static class ent_bsns {

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
		public static String newSelect(ent_bsns.Column[] columns) {
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
		public static String newInsert(ent_bsns.Column[] columns) {
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
		public static String newUpdate(ent_bsns.Column[] columns) {
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
		public static String[] namesOf(ent_bsns.Column[] columns) {
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
		public static String[] namesOf(ent_bsns.Column[] columns, String template) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				map.put("name", columns[i].name());
				cols[i] = StrSubstitutor.replace(template, map);
			}
			return cols;
		}
		
	}
	

}