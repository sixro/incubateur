package com.github.sixro.minihabits.core.infrastructure.domain;

import java.util.*;

import com.badlogic.gdx.Preferences;
import com.github.sixro.minihabits.core.domain.*;

public class PreferencesBasedRepository implements Repository {

	private final Preferences prefs;
	
	public PreferencesBasedRepository(Preferences prefs) {
		super();
		this.prefs = prefs;
	}

	@Override
	public Set<MiniHabit> findAll() {
		String text = prefs.getString("mini_habits");
		if (text == null || text.trim().isEmpty())
			return new LinkedHashSet<MiniHabit>();
		return newMiniHabits(text);
	}

	@Override
	public void add(MiniHabit miniHabit) {
		Set<MiniHabit> list = findAll();
		list.add(miniHabit);
		
		prefs.putString("mini_habits", asString(list));
		prefs.flush();
	}

	@Override
	public void update(Collection<MiniHabit> list) {
		Set<MiniHabit> currentList = findAll();
		currentList.removeAll(list);
		currentList.addAll(list);
		
		prefs.putString("mini_habits", asString(currentList));
		prefs.flush();
	}

	@Override
	public void updateProgressDate(DateAtMidnight aDate) {
		prefs.putLong("last_feedback_timestamp", aDate.getTime());
		prefs.flush();
	}

	@Override
	public DateAtMidnight lastFeedbackDate() {
		long timestamp = prefs.getLong("last_feedback_timestamp");
		if (timestamp == 0L)
			return null;
		return DateAtMidnight.from(timestamp);
	}

	private Set<MiniHabit> newMiniHabits(String text) {
		String[] parts = text.split(",");
		Set<MiniHabit> ret = new LinkedHashSet<MiniHabit>();
		for (String part: parts)
			ret.add(newMiniHabit(part));
		return ret;
	}

	private MiniHabit newMiniHabit(String part) {
		int indexOfColon = part.indexOf(':');
		String label = part.substring(0, indexOfColon);
		Integer daysInProgress = Integer.parseInt(part.substring(indexOfColon +1));
		MiniHabit habit = new MiniHabit(label, daysInProgress);
		return habit;
	}

	private String asString(Collection<MiniHabit> list) {
		StringBuilder b = new StringBuilder();
		int i = 0;
		for (MiniHabit each: list) {
			b.append(each.label() + ":" + each.daysInProgress());
			if (i < list.size()-1)
				b.append(',');
			i++;
		}
		return b.toString();
	}

}
