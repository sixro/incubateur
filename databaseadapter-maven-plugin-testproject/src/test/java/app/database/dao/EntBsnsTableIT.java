package app.database.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import app.database.dao.EntBsnsTable.Record;

public class EntBsnsTableIT {

	private static final DataSource DATA_SOURCE = newOracleDataSource("jdbc:oracle:thin:@10.0.0.46:1551:ORA10A", "DIPMASTER", "DIPMASTER");

	private NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(DATA_SOURCE);

	@SuppressWarnings("serial")
	@Test public void insert_addOneRecord() {
		Map<String, Object> params = new HashMap<String, Object>() {{ put("n_ent_bsns", "Top Secret!"); }};
		jdbc.update("DELETE FROM ent_bsns WHERE n_ent_bsns = :n_ent_bsns", params);
		
		EntBsnsTable table = new EntBsnsTable(DATA_SOURCE);
		table.insert(aRecord());
		
		assertEquals(1, jdbc.queryForInt("SELECT COUNT(*) FROM ent_bsns WHERE n_ent_bsns = :n_ent_bsns", params));
	}

	private Record aRecord() {
		Record record = new Record();
		record.setCEntBsns(BigDecimal.valueOf(999999999L));
		record.setNEntBsns("Top Secret!");
		record.setCTipEntBsns(BigDecimal.valueOf(26L));
		
		record.setNLoginIn("Sys");
		record.setDIni(java.sql.Date.valueOf("2009-09-07"));
		return record;
	}

	private static DataSource newOracleDataSource(String url, String username, String password) {
		Validate.notEmpty(url, "'url' parameter cannot be null or empty");
		Validate.notEmpty(username, "'username' parameter cannot be null or empty");
		Validate.notNull(password, "'password' parameter cannot be null");
		
		Properties properties = new Properties();
		properties.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
		properties.setProperty("url", url);
		properties.setProperty("username", username);
		properties.setProperty("password", password);

		try {
			return BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			throw new RuntimeException("Unable to create Oracle datasource using specified parameters", e);
		}
	}

}
