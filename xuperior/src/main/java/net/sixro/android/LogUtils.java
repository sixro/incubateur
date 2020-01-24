package net.sixro.android;

import android.util.Log;

/**
 * Represents a set of utilities useful to work with Android {@link Log} object.
 */
public class LogUtils {

	private LogUtils() { }

	/**
	 * Returns <code>true</code> if debug is enabled for specified tag.
	 * 
	 * @param tag a tag
	 * @return <code>true</code> if debug is enabled for specified tag, otherwise <code>false</code>
	 */
	public static boolean isDebugEnabled(String tag) {
		return Log.isLoggable(tag, Log.DEBUG);
	}
	
	/**
	 * Returns a <i>tag</i> suitable to be using with Android {@link Log}.
	 * 
	 * <p>
	 * Concats specified prefix and name. E.g. calling {@code LogUtils.toTag("Hello", "World")}, it returns
	 * {@code Hello:World}.<br>
	 * If the concatenation is longer than 23 characters, it truncates it.
	 * </p>
	 * @param prefix
	 * @param name
	 * @return
	 */
	public static String toTag(String prefix, String name) {
		String tag = prefix + ":" + name;
		if (tag.length() > 23)
			tag = tag.substring(0, 23);
		return tag;
	}
	
}
