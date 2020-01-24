package com.github.sixro.minihabits.core.infrastructure.text;

import java.text.*;
import java.util.Date;

public class JavaDateTimeFormatter implements DateTimeFormatter {

	@Override
	public String format(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	@Override
	public Date parse(String text, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse '" + text + "' with pattern '" + pattern + "'", e);
		}
	}

}
