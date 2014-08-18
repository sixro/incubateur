package db4j.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import propertiesutils.PropertiesUtils;

/**
 * Represents a factory of {@link DataSource}.
 */
public class DataSourceFactory {

	private static final Map<String, DataSource> DATA_SOURCES = new HashMap<>();
	
	private DataSourceFactory() { }
	
	/**
	 * Returns a {@link DataSource} using system properties starting with specified prefix.
	 * 
	 * <p>
	 * This method follows the practice found in {@code Integer.getInteger(String systemProperty)}, {@code Boolean.getBoolean(String systemProperty)}, etc...
	 * So it find all system properties with specified prefix, remove it creating a set of sub properties. Then create a DataSource with them.<br>
	 * Once created, the DataSource is preserved in memory. In this way if you ask for it more than once, it's created only in the first call.
	 * </p>
	 * 
	 * @param systemPropertyPrefix a prefix
	 * @return a {@link DataSource}
	 */
	public synchronized static DataSource getDataSource(String systemPropertyPrefix) {
		DataSource dataSource = DATA_SOURCES.get(systemPropertyPrefix);
		if (dataSource == null) {
			Properties dataSourceProperties = PropertiesUtils.subProperties(System.getProperties(), systemPropertyPrefix);
			dataSource = newDataSource(dataSourceProperties);
			DATA_SOURCES.put(systemPropertyPrefix, dataSource);
		}
		return dataSource;
	}
	
	/**
	 * Create a {@link DataSource} using specified properties.
	 * 
	 * <p>
	 * This method uses {@code commons-dbcp} so, please refer to the configuration
	 * page of the library to know what properties to include.
	 * </p>
	 * 
	 * @param properties {@link Properties}
	 * @return a {@link DataSource}
	 * @throws DataSourceCreationException if an error occurs
	 */
	public static DataSource newDataSource(Properties properties) {
		try {
			DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
			return dataSource;
		} catch (Exception e) {
			throw new DataSourceCreationException("Unable to create data source using specified properties " + properties, e);
		}
	}
	
}
