package net.sixro.stopeat.util;

public class StringUtils {

	private StringUtils() { }

	/**
	 * Returns true if specified text is blank.
	 * @param text a text
	 * @return true if specified text is blank
	 */
	public static boolean isBlank(String text) {
		return (text == null || text.trim().length() == 0);
	}

	/**
	 * Returns true if anyone of specified texts is blank.
	 * @param texts some texts
	 * @return true if anyone of specified texts is blank
	 */
	public static boolean anyBlank(String... texts) {
		for (String text : texts) {
			if (isBlank(text))
				return true;
		}
		return false;
	}

}
