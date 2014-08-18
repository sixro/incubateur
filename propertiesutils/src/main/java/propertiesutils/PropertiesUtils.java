package propertiesutils;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Contains utilities on {@link Properties}.
 */
public class PropertiesUtils {

	private static final String NEW_LINE = System.getProperty("line.separator");

	/**
	 * Defines how {@link Properties} has to be copied from source to dest.
	 * 
	 * @see PropertiesUtils#copy(Properties, Properties, CopyMode)
	 */
	public static enum CopyMode {
		/**
		 * Overwrite existing properties.
		 */
		overwrite, 
		/**
		 * Do no overwrite existing properties.
		 */
		dont_overwrite 
	};
	
	private PropertiesUtils() { }

	/**
	 * Returns all properties in specified one starting with specified prefix.
	 * 
	 * <p>
	 * The prefix will be removed from each one.
	 * </p>
	 * 
	 * @param properties {@link Properties}
	 * @param prefix a prefix
	 * @return {@link Properties}
	 */
	public static Properties subProperties(Properties properties, String prefix) {
		Set<String> propertyNames = properties.stringPropertyNames();
		Properties subProperties = new Properties();
		for (String propertyName : propertyNames) {
			if (propertyName.startsWith(prefix)) {
				String subPropertyName = propertyName.substring(prefix.length());
				if (subPropertyName.startsWith("."))
					subPropertyName = subPropertyName.substring(1);
				subProperties.setProperty(subPropertyName, properties.getProperty(propertyName));
			}
		}
		return subProperties;
	}

	/**
	 * List specified {@link Properties} in alphabetical order.
	 * 
	 * @param properties {@link Properties}
	 * @param writer any {@link Writer}
	 */
	public static void listOrdered(Properties properties, Writer writer) {
		Set<String> propertyNames = properties.stringPropertyNames();
		List<String> listOfPropertyNames = new ArrayList<>(propertyNames);
		Collections.sort(listOfPropertyNames);
		
		boolean written = false;
		for (String propertyName : listOfPropertyNames) {
			try {
				if (written)
					writer.append(NEW_LINE);
			
				writer.append(propertyName)
					.append('=')
					.append(properties.getProperty(propertyName));
				
				written = true;
			} catch (IOException e) {
				throw new RuntimeException("unable to list properties", e);
			}
		}
	}

	/**
	 * Copy {@link Properties} of source into dest, using specified copy mode.
	 * 
	 * @param source source of {@link Properties}
	 * @param dest destination {@link Properties}
	 * @param copyMode a CopyMode
	 */
	public static void copy(Properties source, Properties dest, CopyMode copyMode) {
		Set<String> propertyNames = source.stringPropertyNames();
		if (CopyMode.overwrite.equals(copyMode)) {
			for (String propertyName : propertyNames) {
				dest.setProperty(propertyName, source.getProperty(propertyName));
			}
		} else if (CopyMode.dont_overwrite.equals(copyMode)) {
			for (String propertyName : propertyNames) {
				String value = dest.getProperty(propertyName);
				if (value == null)
					dest.setProperty(propertyName, source.getProperty(propertyName));
			}
		} else throw new UnsupportedOperationException(copyMode.name() + " " + CopyMode.class.getName() +" is not supported");
	}
	
	/**
	 * Load {@link Properties} from specified resource found in classpath.
	 * 
	 * @param resourceClasspath the resource classpath
	 * @return {@link Properties}
	 */
	public static Properties loadFromResource(String resourceClasspath) {
		try {
			Properties properties = new Properties();
			properties.load(PropertiesUtils.class.getResourceAsStream(resourceClasspath));
			return properties;
		} catch (IOException e) {
			throw new RuntimeException("unable to load properties from resource '" + resourceClasspath + "'", e);
		}
	}
	
}
