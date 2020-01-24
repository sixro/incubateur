package db4idlers;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * Represents a {@link DataSource} factory.
 * 
 * <p>
 * {@code commons-dbcp} is used internally to create {@link DataSource}.
 * </p>
 */
public class DataSourceFactory {

	private DataSourceFactory() { }

	public static DataSource newDataSource(String driverClassName, String url, String username, String password) {
		try {
			Properties properties = new Properties();
			properties.setProperty("driverClassName", driverClassName);
			properties.setProperty("url", url);
			properties.setProperty("username", username);
			properties.setProperty("password", password);
			return BasicDataSourceFactory.createDataSource(properties);
		} catch (java.lang.Exception e) {
			throw new DataSourceFactory.Exception("Unable to create datasource for database of integration tests", e);
		}
	}

	public static DataSource newOracleDataSource(String url, String username, String password) {
		return newDataSource("oracle.jdbc.OracleDriver", url, username, password);
	}

	/**
	 * Represents an exception thrown when an error occurs.
	 */
	public static class Exception extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public Exception(String message, Throwable cause) {
			super(message, cause);
		}

		public Exception(String message) {
			super(message);
		}

		public Exception(Throwable cause) {
			super(cause);
		}
		
	}
	
}