package com.github.sixro.minihabits.core.infrastructure.libgdx;

import java.util.*;

import com.github.sixro.minihabits.core.infrastructure.libgdx.log.LogFactory;

public abstract class Observable {

	private static final Log LOG = LogFactory.newLog(Observable.class);
	
	private final transient List<Observer> observers;
	
	public Observable() {
		super();
		this.observers = new LinkedList<Observer>();
	}

	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void notifyObservers(Object... args) {
		LOG.info("Updating observers...");
		
		for (Observer o: observers)
			o.update(this, args);
	}
	
}
