package com.github.sixro.minihabits.core.infrastructure.domain;

import static com.github.sixro.minihabits.core.DateFactory.*;
import static com.github.sixro.minihabits.core.domain.DateAtMidnight.*;
import static org.junit.Assert.*;

import java.util.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import com.badlogic.gdx.Preferences;
import com.github.sixro.minihabits.core.DateFactory;
import com.github.sixro.minihabits.core.domain.*;

public class PreferencesBasedRepositoryTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Preferences preferences = context.mock(Preferences.class);
	private PreferencesBasedRepository repo = new PreferencesBasedRepository(preferences);
	
	@Test
	public void no_habits() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getString("mini_habits");
				will(returnValue(""));
		}});
		assertTrue(repo.findAll().isEmpty());
	}

	@Test
	public void two_habits() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getString("mini_habits");
				will(returnValue("One Pushup:1, Cooking:2"));
		}});
		assertEquals(2, repo.findAll().size());
	}

	@Test
	public void one_minihabit_with_days_in_progress() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getString("mini_habits");
				will(returnValue("One Pushup:3"));
		}});
		MiniHabit habit = repo.findAll().iterator().next();
		assertEquals("One Pushup", habit.label());
		assertEquals(3, habit.daysInProgress());
	}


	@Test
	public void add() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getString("mini_habits");
				will(returnValue("One Pushup:1"));
			oneOf(preferences).putString("mini_habits", "One Pushup:1,Cooking:3");
			oneOf(preferences).flush();
		}});
		
		repo.add(new MiniHabit("Cooking", 3));;
	}

	@Test
	public void update() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getString("mini_habits");
				will(returnValue("One Pushup:1,Cooking:3"));
			oneOf(preferences).putString("mini_habits", "Cooking:3,One Pushup:2");
			oneOf(preferences).flush();
		}});
		
		repo.update(asSet(new MiniHabit("Cooking", 3), new MiniHabit("One Pushup", 2)));
	}

	@Test
	public void no_lastFeedbackDate() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getLong("last_feedback_timestamp");
				will(returnValue(0L));
		}});
		
		assertNull(repo.lastFeedbackDate());
	}

	@Test
	public void lastFeedbackDate() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).getLong("last_feedback_timestamp");
				will(returnValue(1495144800000L));
		}});
		
		assertEquals(DateAtMidnight.from(DateFactory.date("19 May 2017")), repo.lastFeedbackDate());
	}

	@Test
	public void updateProgressDate() {
		context.checking(new Expectations() {{ 
			oneOf(preferences).putLong("last_feedback_timestamp", 1495144800000L);
			oneOf(preferences).flush();
		}});
		
		repo.updateProgressDate(from(date("19 May 2017")));
	}

	private Set<MiniHabit> asSet(MiniHabit... miniHabits) {
		Set<MiniHabit> set = new LinkedHashSet<MiniHabit>();
		for (MiniHabit each: miniHabits)
			set.add(each);
		return set;
	}

}
