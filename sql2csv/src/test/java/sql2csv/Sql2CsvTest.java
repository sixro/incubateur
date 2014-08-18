package sql2csv;

import static org.junit.Assert.*;

import java.io.*;

import javax.sql.DataSource;

import org.junit.*;

import sql2csv.util.*;

public class Sql2CsvTest {

	private DB db;
	private StringWriter writer;

	@Test public void print_csv() throws IOException {
		db.execute("insert into example (name, birth_date, salary) values ('Giuseppe', DATE('1975-09-21'), 1300)");
        db.execute("insert into example (name, birth_date, salary) values ('Giuseppe', DATE('1975-09-21'), 1400)");
        db.execute("insert into example (name, birth_date, salary) values ('Maria',    DATE('1975-10-21'), 1200)");

		new Sql2Csv(db, "SELECT name AS \"Name\", birth_date AS \"Birth date\", salary AS \"Salary\" FROM example WHERE salary <= :maxSalary", writer)
			.withSeparator("|")
            .withParameter("maxSalary", 1300)
            .showHeader()
			.run();
		
		assertEquals("Name|Birth date|Salary\r\nGiuseppe|1975-09-21T00:00:00|1300\r\nMaria|1975-10-21T00:00:00|1200\r\n", writer.toString());
	}

	@Before public void setup() {
		writer = new StringWriter();
		DataSource dataSource = DataSourceFactory.newDataSource("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:memory:testDB;create=true");
		db = new DB(dataSource);
        try { db.execute("drop table example"); }
        catch (Throwable ignoreme) { }
		db.execute("create table example (name VARCHAR(100), birth_date DATE, salary INT)");
	}

}
