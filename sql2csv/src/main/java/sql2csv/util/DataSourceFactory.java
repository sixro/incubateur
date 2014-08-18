package sql2csv.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DataSourceFactory {

	private DataSourceFactory() { }
	
	public static DataSource newDataSource(String driverClassName, String url) {
		Properties props = new Properties();
		props.setProperty("driverClassName", driverClassName);
		props.setProperty("url", url);
		
		try {
			return BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			throw new RuntimeException("unexpected error", e);
		}
	}

	public static DataSource newDataSource(String driverClassName, String url, String username, String password) {
		Properties props = new Properties();
		props.setProperty("driverClassName", driverClassName);
		props.setProperty("url", url);
		props.setProperty("username", username);
		props.setProperty("password", password);
		
		try {
			return BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			throw new RuntimeException("unexpected error", e);
		}
	}

}
