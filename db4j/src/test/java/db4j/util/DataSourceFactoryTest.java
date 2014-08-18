package db4j.util;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataSourceFactoryTest {

	private static final String MYDS = "myds";
	private static final String SYSPROP_MYDS_URL = MYDS + ".url";
	private static final String SYSPROP_MYDS_DRIVER_CLASS_NAME = MYDS + ".driverClassName";

	private static final String JDBC_URL = "jdbc:derby:db;create=true";
	private static final String JDBC_DRIVER_CLASS_NAME = "org.apache.derby.jdbc.EmbeddedDriver";
	
	@Before public void setup() {
		clearSystemProperties();
	}
	
	@Test public void returns_a_dataSource() {
		Properties properties = new Properties();
		properties.setProperty("url", JDBC_URL);
		properties.setProperty("driverClassName", JDBC_DRIVER_CLASS_NAME);
		DataSource dataSource = DataSourceFactory.newDataSource(properties);
		assertNotNull(dataSource);
	}

	@Test public void returns_a_dataSource_creating_it_using_system_properties() {
		System.setProperty(SYSPROP_MYDS_URL, JDBC_URL);
		System.setProperty(SYSPROP_MYDS_DRIVER_CLASS_NAME, JDBC_DRIVER_CLASS_NAME);
		
		DataSource dataSource = DataSourceFactory.getDataSource(MYDS);
		assertNotNull(dataSource);

		DataSource dataSource2 = DataSourceFactory.getDataSource(MYDS);
		assertEquals(dataSource, dataSource2);
	}
	
	@After public void teardown() {
		clearSystemProperties();
	}

	private void clearSystemProperties() {
		System.clearProperty(SYSPROP_MYDS_URL);
		System.clearProperty(SYSPROP_MYDS_DRIVER_CLASS_NAME);
	}
	
}
