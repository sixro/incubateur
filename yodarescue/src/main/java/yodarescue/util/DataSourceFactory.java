package yodarescue.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DataSourceFactory {

  private DataSourceFactory() { }
  
  public static DataSource newDataSource(Properties properties) {
    try {
      return BasicDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      throw new RuntimeException("unable to load datasource using properties " + properties, e);
    }
  }

  public static DataSource newDataSource(String resourceInClasspath) {
    try {
      InputStream stream = DataSourceFactory.class.getResourceAsStream(resourceInClasspath);
      if (stream == null)
        throw new IllegalArgumentException("Unable to find resource '" + resourceInClasspath + "' in classpath");
      Properties properties = new Properties();
      properties.load(stream);
      return newDataSource(properties);
    } catch (IOException e) {
      throw new RuntimeException("unable to load properties from resource in classpath", e);
    }
  }

}
