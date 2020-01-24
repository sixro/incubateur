package com.github.sixro.minihabits.core.domain;

import java.util.Date;

/**
 * Represents a feedback for a specified minihabits in a specific date.
 */
public class Feedback {

	private final Date dateAtMidnight;
	private final boolean done;

	private Feedback(Date dateAtMidnight, boolean done) {
		super();
		this.dateAtMidnight = dateAtMidnight;
		this.done = done;
	}

	public static Feedback done(Date dateAtMidnight) {
		return new Feedback(dateAtMidnight, true);
	}
	
	public static Feedback skipped(Date dateAtMidnight) {
		return new Feedback(dateAtMidnight, false);
	}
	
	public Date getDateAtMidnight() {
		return dateAtMidnight;
	}

	public boolean isDone() {
		return done;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAtMidnight == null) ? 0 : dateAtMidnight.hashCode());
		result = prime * result + (done ? 1231 : 1237);
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
		Feedback other = (Feedback) obj;
		if (dateAtMidnight == null) {
			if (other.dateAtMidnight != null)
				return false;
		} else if (!dateAtMidnight.equals(other.dateAtMidnight))
			return false;
		if (done != other.done)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Feedback [dateAtMidnight=" + dateAtMidnight + ", done=" + done + "]";
	}

}
