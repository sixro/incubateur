package com.github.sixro.minihabits.core.domain;

import static com.github.sixro.minihabits.core.DateFactory.*;
import static com.github.sixro.minihabits.core.domain.DateAtMidnight.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class DateAtMidnightTest {

	@Test
	public void create() {
		DateAtMidnight dateAtMidnight = DateAtMidnight.from(datetime("28 Apr 2017 10:21"));
		assertHasNoTime(dateAtMidnight);
	}

	@Test
	public void no_dates_between() {
		Collection<DateAtMidnight> dates = DateAtMidnight.datesBetween(from(datetime("28 Apr 2017 10:21")), from(datetime("28 Apr 2017 10:21")));
		assertTrue(dates.isEmpty());
	}

	@Test
	public void one_dates_between() {
		Collection<DateAtMidnight> dates = DateAtMidnight.datesBetween(from(datetime("28 Apr 2017 10:21")), from(datetime("29 Apr 2017 10:21")));
		assertEquals(1, dates.size());
		assertEquals(date("29 Apr 2017"), dates.iterator().next());
	}

	@Test
	public void two_dates_between_crossing_month() {
		List<DateAtMidnight> dates = DateAtMidnight.datesBetween(from(date("29 Apr 2017")), from(date("01 May 2017")));
		assertEquals(2, dates.size());
		assertEquals(date("30 Apr 2017"), dates.get(0));
		assertEquals(date("01 May 2017"), dates.get(1));
	}

	private void assertHasNoTime(DateAtMidnight dateAtMidnight) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateAtMidnight);
		assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
		assertEquals(0, calendar.get(Calendar.MILLISECOND));
	}

}
