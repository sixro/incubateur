package com.github.sixro.minihabits.core.domain;

import java.util.*;

/**
 * @deprecated This is too complex
 */
public class MultiFeedback {

	private final Date dateAtMidnight;
	private final Map<MiniHabit, Boolean> doneByMiniHabit;
	
	public MultiFeedback(Date dateAtMidnight, Map<MiniHabit, Boolean> doneByMiniHabit) {
		super();
		this.dateAtMidnight = dateAtMidnight;
		this.doneByMiniHabit = doneByMiniHabit;
	}

	public Date getDateAtMidnight() {
		return dateAtMidnight;
	}

	public Map<MiniHabit, Boolean> getDoneByMiniHabit() {
		return Collections.unmodifiableMap(doneByMiniHabit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAtMidnight == null) ? 0 : dateAtMidnight.hashCode());
		result = prime * result + ((doneByMiniHabit == null) ? 0 : doneByMiniHabit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultiFeedback other = (MultiFeedback) obj;
		if (dateAtMidnight == null) {
			if (other.dateAtMidnight != null)
				return false;
		} else if (!dateAtMidnight.equals(other.dateAtMidnight))
			return false;
		if (doneByMiniHabit == null) {
			if (other.doneByMiniHabit != null)
				return false;
		} else if (!doneByMiniHabit.equals(other.doneByMiniHabit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MultiFeedback [dateAtMidnight=" + dateAtMidnight + ", doneByMiniHabit=" + doneByMiniHabit + "]";
	}

}
