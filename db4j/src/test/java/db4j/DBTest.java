package db4j;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import db4j.util.DataSourceFactory;

import propertiesutils.PropertiesUtils;

public class DBTest {
	
	private static final String SQL_INSERT = asSQL(Employee.class, "inserting");
	private static final String SQL_ANY = asSQL(Employee.class, "any");
	private static final String SQL_ALL = asSQL(Employee.class, "all");

	private JdbcTemplate jdbc;
	private DB db;

	@Before public void setup() {
		;
		DataSource dataSource = DataSourceFactory.newDataSource(PropertiesUtils.loadFromResource("/dataSource.properties"));
		jdbc = new JdbcTemplate(dataSource);
		db = new DB(dataSource);
		
		try { jdbc.execute("DROP TABLE employee"); } catch (Throwable ignore) { }
		jdbc.execute("CREATE TABLE employee (id INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT employee_pk PRIMARY KEY, first_name VARCHAR(100), last_name VARCHAR(100), birth_date DATE)");
	}
	
	@Test public void fetch_returns_previously_inserted() throws Exception {
		long id = 1L;
		Employee employee = new Employee("Mario", "Rossi", new Date());
		db.update(employee, SQL_INSERT); // FIXME returns the ID
		
		Employee fetched = db.fetch(Employee.class, SQL_ANY, id);
		Assert.assertNotNull(fetched);
	}

	@Test public void list_returns_all_previously_inserted() throws Exception {
		db.update(new Employee("Mario", "Rossi", new Date()), SQL_INSERT);
		db.update(new Employee("Giuseppe", "Verdi", new Date()), SQL_INSERT);
		
		List<Employee> list = db.list(Employee.class, SQL_ALL);
		System.out.println(list);
		Assert.assertEquals(2, list.size());
	}

//	@Test public void loadSQL_returns_sql_from_a_file() throws Exception {
//		Employee employee = new Employee("Mario", "Rossi", new Date());
//		String sql = db.loadSQL(employee.getClass().getName(), "inserting");
//		Assert.assertEquals(IOUtils.toString(DBTest.class.getResourceAsStream("/db4j/Employee-inserting.sql")), sql);
//	}

	static String asSQL(Class<?> clazz, String sqlID) {
		return asSQL(clazz.getName(), sqlID);
	}
	
	static String asSQL(String className, String sqlID) {
		try {
			String classpathStream = new StringBuilder("/")
				.append(className.replace('.', '/'))
				.append("-")
				.append(sqlID)
				.append(".sql")
				.toString();
			return IOUtils.toString(DB.class.getResourceAsStream(classpathStream));
		} catch (IOException e) {
			throw new DBException("Unable to load sql '" + sqlID + "' of object " + className + " due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

}
