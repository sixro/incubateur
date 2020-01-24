package com.github.sixro.minihabits.core.infrastructure.domain;

import static com.github.sixro.minihabits.core.util.DateFactory.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.github.sixro.minihabits.core.infrastructure.domain.JavaBasedCalendar;

public class JavaBasedCalendarTest {

	private JavaBasedCalendar cal = new JavaBasedCalendar();

	@Test
	public void dayBefore() {
		assertEquals(date("03 May 2017"), cal.dayBefore(date("04 May 2017")));
	}

	@Test
	public void dayBefore_in_the_beginning_of_a_month() {
		assertEquals(date("30 Apr 2017"), cal.dayBefore(date("01 May 2017")));
	}

	@Test
	public void toDay() {
		assertEquals(date("30 Apr 2017"), cal.toDateAtMidnight("2017-04-30"));
	}

	@Test
	public void formatAsDateAtMidnight() {
		assertEquals("2017-05-03", cal.formatAsDateAtMidnight(date("03 May 2017")));
	}

	@Test
	public void toDateAtMidnight() {
		assertEquals(date("03 May 2017"), cal.toDateAtMidnight(datetime("03 May 2017 12:23")));
	}

}
