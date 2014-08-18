
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_CANALE_VENDITA}.
 *
 * <p>
 * Elenco dei canali di vendita
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCanaleVenditaTable {

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
	public static String newSelect(CdcCanaleVenditaTable.Column[] columns) {
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
	public static String newInsert(CdcCanaleVenditaTable.Column[] columns) {
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
	public static String newUpdate(CdcCanaleVenditaTable.Column[] columns) {
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
	public static String[] namesOf(CdcCanaleVenditaTable.Column[] columns) {
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
	public static String[] namesOf(CdcCanaleVenditaTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}