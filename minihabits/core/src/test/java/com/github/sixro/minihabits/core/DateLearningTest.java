package com.github.sixro.minihabits.core;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

public class DateLearningTest {

	private static final int ONE_DAY = 24 * 60 * 60 * 1000;

	@Test public void test() {
		System.out.println(DateFactory.date("19 May 2017").getTime());
	}
	
	@Test
	@Ignore
	public void one_day() {
		long timestamp = 1495663200000L;
		System.out.println((now() -timestamp) + " vs " + ONE_DAY);
		assertTrue(now() -timestamp > ONE_DAY);
	}

	private long now() {
		return new Date().getTime();
	}
}
