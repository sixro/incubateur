package com.github.sixro.minihabits.core.domain;

import com.github.sixro.minihabits.core.infrastructure.libgdx.*;
import com.github.sixro.minihabits.core.infrastructure.libgdx.log.LogFactory;

public class MiniHabit {

	private static final Log LOG = LogFactory.newLog(MiniHabit.class);
	
	private String label;
	private int daysInProgress;

	/**
	 * @deprecated In use by framework/objects in need of instantiation by reflection
	 */
	MiniHabit() {
		super();
	}

	public MiniHabit(String label) {
		this(label, 0);
	}
	
	public MiniHabit(String label, int daysInProgress) {
		super();
		this.label = label;
		this.daysInProgress = daysInProgress;
	}

	public String label() {
		return label;
	}

	public int daysInProgress() {
		return daysInProgress;
	}

	public void incDaysInProgress() {
		LOG.info("Incrementing days in progress...");
		
		daysInProgress++;
	}

	public void resetProgress() {
		daysInProgress = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		MiniHabit other = (MiniHabit) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MiniHabit [label=" + label + ", daysInProgress=" + daysInProgress + "]";
	}

}
