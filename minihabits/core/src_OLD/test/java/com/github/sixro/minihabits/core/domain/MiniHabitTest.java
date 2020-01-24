package com.github.sixro.minihabits.core.domain;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class MiniHabitTest {

	@Test
	public void equality() {
		System.out.println(new MiniHabit("Hello world"));
		assertEquals(new MiniHabit("Hello"), new MiniHabit("Hello"));
	}

	@Test
	public void just_started() {
		assertEquals(0, new MiniHabit("Hello").daysInProgress());
	}

	@Test
	public void three_days() {
		assertEquals(3, new MiniHabit("Hello", threeDaysAgo()).daysInProgress());
	}

	private Date threeDaysAgo() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(java.util.Calendar.DAY_OF_MONTH, -3);
		return cal.getTime();
	}

}
