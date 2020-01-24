package net.sixro.util;

/**
 * Represents a set of utilities useful to work with {@link String}s.
 */
public class StringUtils {

	private StringUtils() { }

	/**
	 * Returns specified texts joined with specified separator.
	 * 
	 * @param texts some texts
	 * @param separator separator
	 * @return a text
	 */
	public static String join(String[] texts, String separator) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < texts.length; i++) {
			if (b.length() > 0)
				b.append(separator);
			
			b.append(texts[i]);
		}
		
		return b.toString();
	}

	/**
	 * Returns the specified array of int as texts.
	 * 
	 * @param values array of int
	 * @return array of texts
	 */
	public static String[] toStrings(int[] values) {
		String[] texts = new String[values.length];
		for (int i = 0; i < values.length; i++)
			texts[i] = Integer.toString(values[i]);
		return texts;
	}
	
}
