package com.github.sixro.minihabits.core.domain;

import static org.junit.Assert.*;

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
	public void reset_progress() {
		MiniHabit habit = new MiniHabit("Hello", 4);
		habit.resetProgress();
		assertEquals(0, habit.daysInProgress());
	}

}
