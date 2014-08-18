package tabl;

import static org.junit.Assert.*;
import static tabl.EmployeeColumns.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DBTableDerbyPrimaryKeyNotInColumnsTest {

	private static final String EMPLOYEES_TABLE = "employees";
	
	private Connection connection;
	private DBTable<EmployeeColumns> table;
	
	@Test public void add_addOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
			.with(LEVEL, BigDecimal.ONE)
			.with(PROJECT_MANAGER, true);
		
		table.add(row);
		
		assertEquals(1, table.count());
	}

	// NOTE: this is delegated to the database
	@Ignore public void add_throwAnErrorIfAnotherRowMatchingKeyColumnsExists() { }

	@Test public void update_updateOneRow() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true));
		
		Row<EmployeeColumns> row2 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		table.update(row2);
		
		assertEquals(1, table.count());
		Row<EmployeeColumns> row = table.first();
		assertEquals(BigDecimal.ONE, row.get(LEVEL));
	}

	@Test(expected=IllegalStateException.class)
	public void update_throwAnErrorIfNoRowMatchesKeys() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true));
			
		table.update(Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "XXXX")
			.with(LEVEL, BigDecimal.ONE));
	}
	
	@SuppressWarnings("serial")
	@Test public void update_updateAllRowsMatching() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, false));
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "5678")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-16"))
				.with(LEVEL, BigDecimal.ONE)
				.with(PROJECT_MANAGER, false));
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "XXX")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-17"))
				.with(LEVEL, BigDecimal.ONE)
				.with(PROJECT_MANAGER, true));
		
		table.update(
			new LinkedHashMap<Column,Object>() {{ put(LEVEL, BigDecimal.TEN); }}, 
			new LinkedHashMap<Column,Object>() {{ put(LEVEL, BigDecimal.ONE); }});
		
		assertEquals(3, table.count());
		Iterator<Row<EmployeeColumns>> it = table.iterator();
		assertEquals(BigDecimal.ZERO, it.next().get(LEVEL));
		assertEquals(BigDecimal.TEN, it.next().get(LEVEL));
		assertEquals(BigDecimal.TEN, it.next().get(LEVEL));
	}
	
	@Test
	public void last_returnsTheSameAsFirstWhitOneRow() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true));

		assertEquals("last() equals to first()", table.first(), table.last());
	}
	
	@Test public void iterable() {
		Row<EmployeeColumns> row1 = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true);
		table.add(row1);
		Row<EmployeeColumns> row2 = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "5678")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ONE)
				.with(PROJECT_MANAGER, false);
		table.add(row2);
		
		Iterator<Row<EmployeeColumns>> it = table.iterator();
		assertEquals(row1, it.next());
		assertEquals(row2, it.next());
	}

	@Test public void remove_removeOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true);
		table.add(row);
		
		table.remove(row);
		assertEquals(0, table.count());
	}
	
	@SuppressWarnings("serial")
	@Test public void remove_removeAllRowsMatching() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, false));
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "5678")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-16"))
				.with(LEVEL, BigDecimal.ONE)
				.with(PROJECT_MANAGER, false));
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "XXX")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-17"))
				.with(LEVEL, BigDecimal.ONE)
				.with(PROJECT_MANAGER, true));
		
		table.remove(new LinkedHashMap<Column,Object>() {{ put(LEVEL, BigDecimal.ONE); }});
		
		assertEquals(1, table.count());
	}
	
	@Test(expected=IllegalStateException.class)
	public void remove_throwAnErrorIfARowWithThatKeysDoesNotExist() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true);
		
		table.remove(row);
	}

	@Test public void contains_returnsTrueWhenARowWithTheSameKeysAlreadyExists() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true);
		table.add(row);
		
		Row<EmployeeColumns> anotherRow = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		
		assertTrue(table.contains(anotherRow));
	}

	@Before public void setup() throws ClassNotFoundException, SQLException {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		Class.forName(driver);
		connection = DriverManager.getConnection("jdbc:derby:tmp/derbyDB;create=true");
		
		try { drop(EMPLOYEES_TABLE); } catch (SQLException ignore) { }
		create(EMPLOYEES_TABLE, "employee_id INT NOT NULL GENERATED ALWAYS AS IDENTITY, serial_number VARCHAR(20) NOT NULL, date_of_employment DATE NOT NULL, level INT, project_manager SMALLINT");
		
		table = DBTable.of(EmployeeColumns.DEFINITION, SERIAL_NUMBER, connection, EMPLOYEES_TABLE);
	}

	private void drop(String table) throws SQLException {
		execute("DROP TABLE " + table);
	}

	private void create(String table, String content) throws SQLException {
		String sql = new StringBuilder("CREATE TABLE ")
			.append(table)
			.append(" (")
			.append(content)
			.append(")")
			.toString();
		execute(sql);
	}

	private void execute(String sql) throws SQLException {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
		} finally {
			if (statement != null)
				try { statement.close(); } catch (SQLException ignore) { }
		}
	}
	
	private Date date(String text) {
		try {
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			return parser.parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("unable to parse date '" + text + "'", e);
		}
	}
	
}
