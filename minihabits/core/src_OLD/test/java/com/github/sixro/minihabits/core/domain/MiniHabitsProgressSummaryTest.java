package com.github.sixro.minihabits.core.domain;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

import java.util.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import com.github.sixro.minihabits.core.util.DateFactory;

public class MiniHabitsProgressSummaryTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private FeedbacksStorage storage = context.mock(FeedbacksStorage.class);
	
	@Test
	public void no_progress() {
		final MiniHabit aMiniHabit = new MiniHabit("One Pushup");

		context.checking(new Expectations() {{
			oneOf(storage).findFeedbacks(aMiniHabit);
				will(returnValue(Collections.EMPTY_LIST));
		}});
		
		MiniHabitsProgressSummary summary = MiniHabitsProgressSummary.newSummary(storage, asList(aMiniHabit));
		assertEquals(0, summary.daysInProgress(aMiniHabit));
	}

	@Test
	public void two_days_progress() {
		final MiniHabit onePushup = new MiniHabit("One Pushup");
		final List<Feedback> feedbacks = asList(Feedback.done(DateFactory.date("29 May 2017")), Feedback.done(DateFactory.date("30 May 2017")));
		context.checking(new Expectations() {{
			oneOf(storage).findFeedbacks(onePushup);
				will(returnValue(feedbacks));
		}});
		
		MiniHabitsProgressSummary summary = MiniHabitsProgressSummary.newSummary(storage, asList(onePushup));
		assertEquals(2, summary.daysInProgress(onePushup));
	}

	@Test
	public void two_habits() {
		final MiniHabit onePushup = new MiniHabit("One Pushup");
		final MiniHabit cooking = new MiniHabit("Cooking");
		final List<Feedback> onePushupFeedbacks = asList(Feedback.done(DateFactory.date("29 May 2017")));
		final List<Feedback> cookingFeedbacks = asList(Feedback.done(DateFactory.date("29 May 2017")));
		context.checking(new Expectations() {{
			oneOf(storage).findFeedbacks(onePushup);
				will(returnValue(onePushupFeedbacks));
			oneOf(storage).findFeedbacks(cooking);
				will(returnValue(cookingFeedbacks));
		}});
		
		MiniHabitsProgressSummary summary = MiniHabitsProgressSummary.newSummary(storage, asList(onePushup, cooking));
		assertEquals(1, summary.daysInProgress(onePushup));
		assertEquals(1, summary.daysInProgress(cooking));
	}

	@Test
	public void habit_skipped_in_a_day() {
		final MiniHabit onePushup = new MiniHabit("One Pushup");
		final List<Feedback> feedbacks = asList(Feedback.done(DateFactory.date("29 May 2017")), Feedback.done(DateFactory.date("31 May 2017")));
		context.checking(new Expectations() {{
			oneOf(storage).findFeedbacks(onePushup);
				will(returnValue(feedbacks));
		}});
		
		MiniHabitsProgressSummary summary = MiniHabitsProgressSummary.newSummary(storage, asList(onePushup));
		//assertEquals(1, summary.daysInProgress(onePushup));

		// FIXME contare i buchi non e' banale... si parla di giorni... una possibilita' sarebbe quella di tenere solo un contatore ed eventualmente quello totale...
	}
	
	// FIXME what about holes between today and date of last feedbacks?
	
}
