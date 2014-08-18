
package app.database.dao;

import java.util.*;

import javax.annotation.Generated;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


/**
 * Represents {@code DAO} for table {@code CDC_CANALE_VENDITA}.
 *
 * @author databaseadapter-maven-plugin
 */
@Generated(value="databaseadapter-maven-plugin")
public class CdcCanaleVenditaTable {

	private static final Log LOG = LogFactory.getLog(CdcCanaleVenditaTable.class);
	
	/**
	 * Contains the name of the table.
	 *
	 * <p>
	 * Can be used to format others {@code SQL}.
	 * </p>
	 */		
	public static final String TABLE = "cdc_canale_vendita";
		
	/**
	 * Contains a preformatted {@code SELECT COUNT(*) FROM cdc_canale_vendita}.
	 */		
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) FROM " + TABLE;

	/**
	 * Contains a preformatted {@code SELECT * FROM cdc_canale_vendita}.
	 */		
	public static final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;

	/**
	 * Contains a preformatted {@code DELETE FROM cdc_canale_vendita}.
	 */		
	public static final String SQL_DELETE = "DELETE FROM " + TABLE;
	
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
		c_canale_vendita, // data type: 3

		/**
		 * Represents column {@code N_CANALE_VENDITA} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Nome canale di vendita
		 * </p>
		 */
		n_canale_vendita, // data type: 12

		/**
		 * Represents column {@code S_CANALE_VENDITA} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Descrizione canale
		 * </p>
		 */
		s_canale_vendita, // data type: 12

		/**
		 * Represents column {@code F_DEFAULT} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Se a Y indica il canale di default
		 * </p>
		 */
		f_default, // data type: 12

		/**
		 * Represents column {@code ORDINAMENTO} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Progressivo per ordinamento canali negli elenchi
		 * </p>
		 */
		ordinamento, // data type: 3

		/**
		 * Represents column {@code S_TIPOLOGIA} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Tipologia canale (BORDO/WEB)
		 * </p>
		 */
		s_tipologia, // data type: 12

		/**
		 * Represents column {@code S_ID_EXPORT} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Identificativo che distingue i vari file di export
		 * </p>
		 */
		s_id_export, // data type: 12

		/**
		 * Represents column {@code S_TIPO_RECORD_EXPORT} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Tipo record usato negli export per identificare i prezzi di vendita
		 * </p>
		 */
		s_tipo_record_export, // data type: 12

		/**
		 * Represents column {@code F_PRZ_MODIFICABILE} of table {@code CDC_CANALE_VENDITA}.
		 *
		 * <p>
		 * Se a Y indica che i prezzi associati al canale non sono modificabili da frontend
		 * </p>
		 */
		f_prz_modificabile // data type: 12

	};

	@SuppressWarnings("unused")
	private final DataSource dataSource;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public CdcCanaleVenditaTable(DataSource dataSource) {
		super();
		Validate.notNull(dataSource, "'dataSource' cannot be null");
		
		this.dataSource = dataSource;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(CdcCanaleVenditaTable.Record record) {
		LOG.info("inserting record " + record + "...");
		
		Column[] columns = record.keySet().toArray(new Column[]{ });
		String sql = new StringBuilder("INSERT INTO ")
			.append(TABLE)
			.append(" (")
			.append(StringUtils.join(namesOf(columns), ", "))
			.append(") VALUES (")
			.append(StringUtils.join(namesOf(columns, ":${name}"), ", "))
			.append(")")
			.toString();
		LOG.debug("... generated SQL: '" + sql);
			
		Map<String, Object> paramMap = new HashMap<String, Object>(columns.length);
		for (Map.Entry<Column, Object> entry : record.entrySet())
			paramMap.put(entry.getKey().name(), entry.getValue());
		
		LOG.debug("... executing statement with parameters: " + paramMap);
		
		int affected = namedJdbcTemplate.update(sql, paramMap);
		if (affected == 0)
			throw new IllegalStateException("execution of a SQL of insert has affected " + affected + " rows?!?");
		
		LOG.info("... insert of record " + record + " done");
	}

	public void update(CdcCanaleVenditaTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void delete(CdcCanaleVenditaTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(CdcCanaleVenditaTable.Record record) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCanaleVenditaTable.Column, Object> what, Map<CdcCanaleVenditaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void updateAll(Map<CdcCanaleVenditaTable.Column, Object> what, String where) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(Map<CdcCanaleVenditaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public void deleteAll(String where) {
		throw new UnsupportedOperationException();
	}

	public CdcCanaleVenditaTable.Record selectFirst(Map<CdcCanaleVenditaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public CdcCanaleVenditaTable.Record selectFirst(String where) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCanaleVenditaTable.Record> selectAll(Map<CdcCanaleVenditaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public List<CdcCanaleVenditaTable.Record> selectAll(String where) {
		throw new UnsupportedOperationException();
	}

	public void foreach(String where, Callback<CdcCanaleVenditaTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public void foreach(Map<CdcCanaleVenditaTable.Column, Object> allMatches, Callback<CdcCanaleVenditaTable.Record> callback) {
		throw new UnsupportedOperationException();
	}

	public int countAll() {
		throw new UnsupportedOperationException();
	}

	public int countAll(Map<CdcCanaleVenditaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public int countAll(String where) {
		throw new UnsupportedOperationException();
	}
	
	public boolean exist(Map<CdcCanaleVenditaTable.Column, Object> allMatches) {
		throw new UnsupportedOperationException();
	}

	public boolean exist(String where) {
		throw new UnsupportedOperationException();
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
	
	public static class Record extends LinkedHashMap<CdcCanaleVenditaTable.Column, Object> {
	
		private static final long serialVersionUID = 1L;

		public Record() {
			super(CdcCanaleVenditaTable.Column.values().length);
		}

		/* C_CANALE_VENDITA: java.math.BigDecimal (3) */
		public java.math.BigDecimal getCCanaleVendita() { return (java.math.BigDecimal) get(CdcCanaleVenditaTable.Column.c_canale_vendita); }

		public void setCCanaleVendita(java.math.BigDecimal value) { put(CdcCanaleVenditaTable.Column.c_canale_vendita, value); }

		/* N_CANALE_VENDITA: String (12) */
		public String getNCanaleVendita() { return (String) get(CdcCanaleVenditaTable.Column.n_canale_vendita); }

		public void setNCanaleVendita(String value) { put(CdcCanaleVenditaTable.Column.n_canale_vendita, value); }

		/* S_CANALE_VENDITA: String (12) */
		public String getSCanaleVendita() { return (String) get(CdcCanaleVenditaTable.Column.s_canale_vendita); }

		public void setSCanaleVendita(String value) { put(CdcCanaleVenditaTable.Column.s_canale_vendita, value); }

		/* F_DEFAULT: String (12) */
		public String getFDefault() { return (String) get(CdcCanaleVenditaTable.Column.f_default); }

		public void setFDefault(String value) { put(CdcCanaleVenditaTable.Column.f_default, value); }

		/* ORDINAMENTO: java.math.BigDecimal (3) */
		public java.math.BigDecimal getOrdinamento() { return (java.math.BigDecimal) get(CdcCanaleVenditaTable.Column.ordinamento); }

		public void setOrdinamento(java.math.BigDecimal value) { put(CdcCanaleVenditaTable.Column.ordinamento, value); }

		/* S_TIPOLOGIA: String (12) */
		public String getSTipologia() { return (String) get(CdcCanaleVenditaTable.Column.s_tipologia); }

		public void setSTipologia(String value) { put(CdcCanaleVenditaTable.Column.s_tipologia, value); }

		/* S_ID_EXPORT: String (12) */
		public String getSIdExport() { return (String) get(CdcCanaleVenditaTable.Column.s_id_export); }

		public void setSIdExport(String value) { put(CdcCanaleVenditaTable.Column.s_id_export, value); }

		/* S_TIPO_RECORD_EXPORT: String (12) */
		public String getSTipoRecordExport() { return (String) get(CdcCanaleVenditaTable.Column.s_tipo_record_export); }

		public void setSTipoRecordExport(String value) { put(CdcCanaleVenditaTable.Column.s_tipo_record_export, value); }

		/* F_PRZ_MODIFICABILE: String (12) */
		public String getFPrzModificabile() { return (String) get(CdcCanaleVenditaTable.Column.f_prz_modificabile); }

		public void setFPrzModificabile(String value) { put(CdcCanaleVenditaTable.Column.f_prz_modificabile, value); }


	}

}