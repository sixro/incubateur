package burgeonapp;

import static org.junit.Assert.*;

import java.util.*;

import javax.sql.DataSource;

import org.junit.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import burgeonapp.DB;

public class DatabaseMetaInfoIT {

	private DB dbmetainfo;

	@Before
	public void setup() {
		DataSource dataSource = new DriverManagerDataSource("jdbc:sqlite:./src/test/resources/chinook.db");
		dbmetainfo = new DB(dataSource, new NamedParameterJdbcTemplate(dataSource));
	}

	@Test
	public void returns_tables() {
		List<Map<String,Object>> tables = dbmetainfo.findTables("%", "%", "%", null);
		assertFalse(tables.isEmpty());
	}

	@Test
	public void include_patterns() {
		List<String> tables = dbmetainfo.findTableNames(new String[]{".*es", "in.*" }, null);
		assertEquals(5, tables.size());
		assertTrue(tables.contains("invoices"));
	}

	@Test
	public void exclude_patterns() {
		List<String> tables = dbmetainfo.findTableNames(new String[]{"in.*" }, new String[]{".*es" });
		assertEquals(2, tables.size());
		assertTrue(tables.contains("invoices"));
	}
	
}
