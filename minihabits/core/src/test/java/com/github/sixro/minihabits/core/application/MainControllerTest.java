package com.github.sixro.minihabits.core.application;

import static com.github.sixro.minihabits.core.DateFactory.*;
import static com.github.sixro.minihabits.core.domain.DateAtMidnight.*;
import static org.junit.Assert.*;

import java.util.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import com.github.sixro.minihabits.core.DateFactory;
import com.github.sixro.minihabits.core.domain.*;

public class MainControllerTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Repository repository = context.mock(Repository.class);
	private MainController controller = new MainController(repository);
	
	@Test
	public void update_habits_progress() {
		final Set<MiniHabit> aSetOfDoneHabits = new LinkedHashSet<MiniHabit>();
		final Set<MiniHabit> allHabits = new LinkedHashSet<MiniHabit>();
		final DateAtMidnight aDate = DateAtMidnight.from(DateFactory.date("20 Apr 2017"));
		
		context.checking(new Expectations() {{ 
			oneOf(repository).findAll();
				will(returnValue(allHabits));
			oneOf(repository).update(allHabits);
			
			oneOf(repository).updateProgressDate(aDate);
		}});
		
		controller.updateHabitsProgress(aSetOfDoneHabits, aDate);
	}

	@Test(expected = LastFeedbackDateUnavailableException.class)
	public void no_next_feedback_date() throws LastFeedbackDateUnavailableException {
		context.checking(new Expectations() {{ 
			oneOf(repository).lastFeedbackDate();
				will(returnValue(null));
		}});
		
		assertNull(controller.nextFeedbackDate(from(date("20 May 2017"))));
	}

	@Test
	public void returns_current_date_as_next_feedback_date() throws LastFeedbackDateUnavailableException {
		context.checking(new Expectations() {{ 
			oneOf(repository).lastFeedbackDate();
				will(returnValue(from(date("19 May 2017"))));
		}});
		
		DateAtMidnight currentDate = from(date("20 May 2017"));
		assertEquals(currentDate, controller.nextFeedbackDate(currentDate));
	}

	@Test
	public void returns_the_day_before() throws LastFeedbackDateUnavailableException {
		context.checking(new Expectations() {{ 
			oneOf(repository).lastFeedbackDate();
				will(returnValue(from(date("19 May 2017"))));
		}});
		
		assertEquals(from(date("20 May 2017")), controller.nextFeedbackDate(from(date("21 May 2017"))));
	}

}
