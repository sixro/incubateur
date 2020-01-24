package com.github.sixro.minihabits.core.domain;

import java.util.*;

/**
 * @deprecated Da buttare
 */
public class AllMiniHabits implements Iterable<MiniHabit> {

	private List<MiniHabit> list;
	private List<AllMiniHabits.Listener> listeners;

	public AllMiniHabits() {
		this(Collections.<MiniHabit>emptyList());
	}

	public AllMiniHabits(List<MiniHabit> list) {
		super();
		this.list = new LinkedList<MiniHabit>(list);
		this.listeners = new LinkedList<AllMiniHabits.Listener>();
	}

	public void addListener(AllMiniHabits.Listener l) {
		this.listeners.add(l);
	}
	
	public void add(MiniHabit miniHabit) {
		list.add(miniHabit);
		for (AllMiniHabits.Listener l: listeners) l.onAdd(this);
	}

	public boolean contains(MiniHabit anHabit) {
		return list.contains(anHabit);
	}

	@Override
	public Iterator<MiniHabit> iterator() {
		return list.iterator();
	}

	public List<MiniHabit> all() {
		return list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		AllMiniHabits other = (AllMiniHabits) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AllMiniHabits [list=" + list + "]";
	}

	public static interface Listener {
		
		void onAdd(AllMiniHabits all);
	
	}
	
}
