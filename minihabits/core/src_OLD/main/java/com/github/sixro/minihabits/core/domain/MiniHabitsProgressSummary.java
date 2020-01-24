package com.github.sixro.minihabits.core.domain;

import java.util.*;

public class MiniHabitsProgressSummary {

	private Map<MiniHabit, Integer> countByHabits;

	private MiniHabitsProgressSummary(Map<MiniHabit, Integer> countByHabits) {
		this.countByHabits = countByHabits;
	}

	public static MiniHabitsProgressSummary newSummary(FeedbacksStorage storage, List<MiniHabit> minihabits) {
		Map<MiniHabit, Integer> countByHabits = new HashMap<MiniHabit, Integer>();
		for (MiniHabit mh: minihabits) {
			List<Feedback> feedbacks = storage.findFeedbacks(mh);
			countByHabits.put(mh, feedbacks.size());
		}
		return new MiniHabitsProgressSummary(countByHabits);
	}

	public int daysInProgress(MiniHabit miniHabit) {
		return countByHabits.get(miniHabit);
	}

	
	
}
