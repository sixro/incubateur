package com.github.sixro.minihabits.core.infrastructure.domain;

import java.text.*;
import java.util.*;

import com.github.sixro.minihabits.core.domain.Calendar;

public class JavaBasedCalendar implements Calendar {

	@Override
	public Date yesterday() {
		return dayBefore(today());
	}

	@Override
	public Date today() {
		return new Date();
	}

	@Override
	public Date toDateAtMidnight(String iso8601Text) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(iso8601Text);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse ISO 8601 date '" + iso8601Text + "'", e);
		}
	}

	@Override
	public Date toDateAtMidnight(Date date) {
		// TODO improve performance of this very DRAFT and UNPROFESSIONAL solution
		return toDateAtMidnight(formatAsDateAtMidnight(date));
	}

	@Override
	public String formatAsDateAtMidnight(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	protected Date dayBefore(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

}
