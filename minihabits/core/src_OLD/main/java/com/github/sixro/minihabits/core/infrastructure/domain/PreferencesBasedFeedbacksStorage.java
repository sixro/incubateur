package com.github.sixro.minihabits.core.infrastructure.domain;

import java.util.*;

import com.badlogic.gdx.*;
import com.badlogic.gdx.utils.Logger;
import com.github.sixro.minihabits.core.domain.*;
import com.github.sixro.minihabits.core.domain.Calendar;

public class PreferencesBasedFeedbacksStorage implements FeedbacksStorage {

	private static final String TAG = PreferencesBasedFeedbacksStorage.class.getSimpleName();
	
	public static final Logger LOG = new Logger(TAG, Logger.INFO);
	
	public static final String VAR_LAST_FEEDBACK_DATE = "last-feedback-date";
	
	private final Preferences prefs;
	private final Calendar calendar;

	public PreferencesBasedFeedbacksStorage(Preferences prefs, Calendar calendar) {
		super();
		this.prefs = prefs;
		this.calendar = calendar;
	}

	@Override
	public boolean existsFeedbackInDate(Date date) {
		LOG.info("checking if exists a feedback in date " + date + "...");
		
		String dateAsText = prefs.getString(VAR_LAST_FEEDBACK_DATE);
		if (dateAsText == null || dateAsText.trim().length() == 0)
			return false;
		Date lastFeedbackDate = calendar.toDateAtMidnight(dateAsText);
		Date dateAtMidnight = calendar.toDateAtMidnight(date);
		LOG.info("... checking " + dateAtMidnight + " against " + lastFeedbackDate);
		if (lastFeedbackDate == null)
			return false;
		
		boolean exists = dateAtMidnight.equals(lastFeedbackDate) || dateAtMidnight.before(lastFeedbackDate);
		
		LOG.info("... returning: " + exists);
		return exists;
	}

	@Override
	public void store(MultiFeedback multiFeedback) {
		String todayAsText = calendar.formatAsDateAtMidnight(multiFeedback.getDateAtMidnight());
		prefs.putString(VAR_LAST_FEEDBACK_DATE, todayAsText);
		prefs.flush();
		
		// TODO should we have to store the feedback right now?
	}

	@Override
	public List<Feedback> findFeedbacks(MiniHabit aMiniHabit) {
		// TODO Auto-generated method stub
		return null;
	}

}
