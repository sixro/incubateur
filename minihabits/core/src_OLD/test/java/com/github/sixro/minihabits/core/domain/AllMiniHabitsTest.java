package com.github.sixro.minihabits.core.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllMiniHabitsTest {

	@Test
	public void add_mini_habit() {
		AllMiniHabits all = new AllMiniHabits();
		MiniHabit anHabit = new MiniHabit("One Push-up");
		all.add(anHabit);
		assertTrue(all.contains(anHabit));
	}

}
