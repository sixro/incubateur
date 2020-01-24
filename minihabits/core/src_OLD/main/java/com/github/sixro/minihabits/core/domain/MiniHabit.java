package com.github.sixro.minihabits.core.domain;

import java.util.Date;

public class MiniHabit {

	private static final int MILLIS_IN_DAY = 24 * 60 * 60 * 1000;
	
	private final String label;
	private final Date startDate;

	public MiniHabit(String label) {
		this(label, new Date());
	}
	
	public MiniHabit(String label, Date startDate) {
		super();
		this.label = label;
		this.startDate = withoutTime(startDate);
	}

	public String label() {
		return label;
	}

	public Date startDate() {
		return startDate;
	}

	public int daysInProgress() {
		Date today = withoutTime(new Date());
		return (int) (today.getTime() - startDate.getTime()) / MILLIS_IN_DAY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MiniHabit [label=" + label + ", startDate=" + startDate + "]";
	}

	private static Date withoutTime(Date date) {
		/*
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.clear(Calendar.HOUR_OF_DAY);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		return cal.getTime();
		*/
		// TODO how can we do this assuming we want GWT?!?
		return date;
	}

}
