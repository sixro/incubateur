package com.github.sixro.minihabits.core.domain;

import java.util.*;

public class DateAtMidnight extends Date {

	private static final int MILLIS_IN_DAY = 24 * 60 * 60 * 1000;
	private static final long serialVersionUID = 1L;

	private DateAtMidnight(long timestamp) {
		super(timestamp);
	}

	public static DateAtMidnight today() {
		return from(new Date());
	}
	
	public static DateAtMidnight from(Date datetime) {
		return new DateAtMidnight(dateWithoutTime(datetime).getTime());
	}

	public static DateAtMidnight from(long timestamp) {
		return new DateAtMidnight(dateWithoutTime(new Date(timestamp)).getTime());
	}
	
	public static List<DateAtMidnight> datesBetween(DateAtMidnight from, DateAtMidnight to) {
		List<DateAtMidnight> dates = new LinkedList<DateAtMidnight>();
		for (long timestamp = from.getTime() +MILLIS_IN_DAY; timestamp <= to.getTime(); timestamp +=MILLIS_IN_DAY)
			dates.add(DateAtMidnight.from(timestamp));
		return dates;
	}

	private static Date dateWithoutTime(Date datetime) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(datetime);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateWithoutTime = cal.getTime();
		return dateWithoutTime;
	}

}
