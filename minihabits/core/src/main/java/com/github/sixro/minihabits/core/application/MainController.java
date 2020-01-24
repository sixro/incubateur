package com.github.sixro.minihabits.core.application;

import java.util.*;

import com.github.sixro.minihabits.core.domain.*;

public class MainController {

	private final Repository repository;
	
	public MainController(Repository repository) {
		this.repository = repository;
	}

	public void updateHabitsProgress(Set<MiniHabit> doneHabits, DateAtMidnight feedbackDate) {
		Set<MiniHabit> allHabits = repository.findAll();
		for (MiniHabit miniHabit : allHabits) {
			if (doneHabits.contains(miniHabit))
				miniHabit.incDaysInProgress();
			else
				miniHabit.resetProgress();
		}

		repository.update(allHabits);
		repository.updateProgressDate(feedbackDate);
	}

	public DateAtMidnight nextFeedbackDate(DateAtMidnight currentDate) throws LastFeedbackDateUnavailableException {
		DateAtMidnight lastFeedbackDate = repository.lastFeedbackDate();
		if (lastFeedbackDate == null)
			throw new LastFeedbackDateUnavailableException("Unable to find last feedback date");
		
		List<DateAtMidnight> dates = DateAtMidnight.datesBetween(lastFeedbackDate, currentDate);
		return (! dates.isEmpty()) ? dates.get(0) : null;
	}

	public void addHabit(MiniHabit miniHabit) {
		repository.add(miniHabit);
	}

	public Collection<MiniHabit> allHabits() {
		return repository.findAll();
	}

}
