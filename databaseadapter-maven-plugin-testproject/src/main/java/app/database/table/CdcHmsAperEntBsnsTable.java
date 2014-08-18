
package app.database.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Represents table {@code CDC_HMS_APER_ENT_BSNS}.
 *
 * <p>
 * Orari di apertura di un Entità di Business per cui si applicano degli orari di apertura/disponibilità.
Ogni Entità qui presente può avere più record, ciascuno indicante l'orario di apertura per il periodo di validità (ad es aperture stagionali con orari diversi)
 * </p>
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcHmsAperEntBsnsTable {

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
	public static String newSelect(CdcHmsAperEntBsnsTable.Column[] columns) {
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
	public static String newInsert(CdcHmsAperEntBsnsTable.Column[] columns) {
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
	public static String newUpdate(CdcHmsAperEntBsnsTable.Column[] columns) {
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
	public static String[] namesOf(CdcHmsAperEntBsnsTable.Column[] columns) {
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
	public static String[] namesOf(CdcHmsAperEntBsnsTable.Column[] columns, String template) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] cols = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			map.put("name", columns[i].name());
			cols[i] = StrSubstitutor.replace(template, map);
		}
		return cols;
	}

}