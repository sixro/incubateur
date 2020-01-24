package com.github.sixro.minihabits.core.infrastructure.domain;

import static com.github.sixro.minihabits.core.util.DateFactory.*;
import static org.junit.Assert.*;

import java.util.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Logger;
import com.github.sixro.minihabits.core.domain.*;
import com.github.sixro.minihabits.core.domain.Calendar;

public class PreferencesBasedFeedbacksStorageTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Preferences prefs = context.mock(Preferences.class);
	private Calendar calendar = context.mock(Calendar.class);
	private PreferencesBasedFeedbacksStorage storage = new PreferencesBasedFeedbacksStorage(prefs, calendar);
	
	@Before public void setup() {
		// TODO rimuovere sto porcame
		PreferencesBasedFeedbacksStorage.LOG.setLevel(Logger.ERROR);
	}
	
	@Test
	public void feedback_exists() {
		final String aDateAsText = "2017-05-04";
		final Date aDateAtMidnight = date("04 May 2017");
		context.checking(new Expectations() {{ 
			oneOf(prefs).getString(PreferencesBasedFeedbacksStorage.VAR_LAST_FEEDBACK_DATE);
				will(returnValue(aDateAsText));
			oneOf(calendar).toDateAtMidnight(aDateAsText);
				will(returnValue(date("04 May 2017")));
			oneOf(calendar).toDateAtMidnight(aDateAtMidnight);
				will(returnValue(aDateAtMidnight));
		}});
		
		assertTrue(storage.existsFeedbackInDate(date("04 May 2017")));
	}

	@Test
	public void feedback_exists_even_if_time_is_not_at_midnight() {
		final String aDateAsText = "2017-05-04";
		final Date aDateTime = datetime("04 May 2017 12:23");
		final Date aDateAtMidnight = date("04 May 2017");
		
		context.checking(new Expectations() {{ 
			oneOf(prefs).getString(PreferencesBasedFeedbacksStorage.VAR_LAST_FEEDBACK_DATE);
				will(returnValue(aDateAsText));
			oneOf(calendar).toDateAtMidnight(aDateAsText);
				will(returnValue(date("04 May 2017")));
			oneOf(calendar).toDateAtMidnight(aDateTime);
				will(returnValue(aDateAtMidnight));
		}});
		
		assertTrue(storage.existsFeedbackInDate(aDateTime));
	}

	@Test
	public void feedback_does_not_exist() {
		final String aDateAsText = "2017-05-03";
		final Date aDateAtMidnight = date("04 May 2017");
		context.checking(new Expectations() {{ 
			oneOf(prefs).getString(PreferencesBasedFeedbacksStorage.VAR_LAST_FEEDBACK_DATE);
				will(returnValue(aDateAsText));
			oneOf(calendar).toDateAtMidnight(aDateAsText);
				will(returnValue(date("03 May 2017")));
			oneOf(calendar).toDateAtMidnight(aDateAtMidnight);
				will(returnValue(aDateAtMidnight));
		}});
		
		assertFalse(storage.existsFeedbackInDate(aDateAtMidnight));
	}

	@Test
	public void prefs_does_not_contain_any_var() {
		context.checking(new Expectations() {{ 
			oneOf(prefs).getString(PreferencesBasedFeedbacksStorage.VAR_LAST_FEEDBACK_DATE);
				will(returnValue(null));
		}});
		
		assertFalse(storage.existsFeedbackInDate(date("04 May 2017")));
	}

	@Test
	public void prefs_var_is_wrong() {
		final Date aDateAtMidnight = date("04 May 2017");
		context.checking(new Expectations() {{ 
			oneOf(prefs).getString(PreferencesBasedFeedbacksStorage.VAR_LAST_FEEDBACK_DATE);
				will(returnValue("xxx"));
			oneOf(calendar).toDateAtMidnight("xxx");
				will(returnValue(null));
			oneOf(calendar).toDateAtMidnight(aDateAtMidnight);
				will(returnValue(aDateAtMidnight));
		}});
		
		assertFalse(storage.existsFeedbackInDate(aDateAtMidnight));
	}

	@Test
	public void store() {
		final Date yesterday = date("03 May 2017");
		context.checking(new Expectations() {{ 
			oneOf(calendar).formatAsDateAtMidnight(yesterday);
				will(returnValue("2017-05-03"));
			oneOf(prefs).putString(PreferencesBasedFeedbacksStorage.VAR_LAST_FEEDBACK_DATE, "2017-05-03");
			oneOf(prefs).flush();
		}});
		
		MultiFeedback multiFeedback = new MultiFeedback(yesterday, Collections.<MiniHabit, Boolean>emptyMap());
		storage.store(multiFeedback);
	}

}
