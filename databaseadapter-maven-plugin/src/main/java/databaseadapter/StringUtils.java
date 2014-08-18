package databaseadapter;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	public StringUtils() {
		super();
	}

	public static String toCamelCase(String nameWithUnderscores) {
		String[] splits = split(nameWithUnderscores, '_');
		StringBuilder b = new StringBuilder();
		for (String each : splits) {
			b.append(StringUtils.capitalize(each.toLowerCase()));
		}
		return b.toString();
	}
	
}
