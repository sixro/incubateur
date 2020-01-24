package com.github.sixro.minihabits.core.util;

import java.text.*;
import java.util.*;

public class DateFactory {

	private DateFactory() { }
	
	public static Date date(String text) {
		try {
			return new SimpleDateFormat("dd MMM yyyy", Locale.US).parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse date '" + text + "'", e);
		}
	}
	
	public static Date datetime(String text) {
		try {
			return new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.US).parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse date '" + text + "'", e);
		}
	}

}
