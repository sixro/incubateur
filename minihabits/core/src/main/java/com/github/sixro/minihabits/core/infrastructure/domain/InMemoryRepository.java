package com.github.sixro.minihabits.core.infrastructure.domain;

import java.util.*;

import com.github.sixro.minihabits.core.domain.*;

public class InMemoryRepository implements Repository {

	private final Set<MiniHabit> miniHabits;
	private DateAtMidnight lastFeedbackDate;
	
	public InMemoryRepository() {
		super();
		this.miniHabits = new LinkedHashSet<MiniHabit>();
		this.lastFeedbackDate = null;
	}

	@Override
	public Set<MiniHabit> findAll() {
		return Collections.unmodifiableSet(miniHabits);
	}

	@Override
	public void add(MiniHabit miniHabit) {
		miniHabits.add(miniHabit);
	}

	@Override
	public void update(Collection<MiniHabit> list) {
		miniHabits.addAll(list);
	}

	@Override
	public void updateProgressDate(DateAtMidnight aDate) {
		this.lastFeedbackDate = aDate;
	}

	@Override
	public DateAtMidnight lastFeedbackDate() {
		return lastFeedbackDate;
	}

}
