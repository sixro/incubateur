package com.github.sixro.minihabits.core.domain;

import java.util.*;

public interface Repository {

	Set<MiniHabit> findAll();

	void add(MiniHabit miniHabit);
	
	void update(Collection<MiniHabit> list);

	void updateProgressDate(DateAtMidnight aDate);

	DateAtMidnight lastFeedbackDate();
	
}
