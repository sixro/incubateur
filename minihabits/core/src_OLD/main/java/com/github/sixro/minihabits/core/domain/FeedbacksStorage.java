package com.github.sixro.minihabits.core.domain;

import java.util.*;

public interface FeedbacksStorage {

	boolean existsFeedbackInDate(Date date);

	void store(MultiFeedback multiFeedback);

	List<Feedback> findFeedbacks(MiniHabit aMiniHabit);

}
