package com.github.sixro.pooomodoro.core;

import java.util.*;

/**
 * Represents a Countdown timer.
 */
public class CountdownTimer {

	private final long millis;
	private final Listeners listeners;

	private Runner runner;

	public CountdownTimer(long millis) {
		super();
		this.millis = millis;

		this.listeners = new Listeners(this);
	}
	
	public void addListener(CountdownTimer.Listener listener) {
		this.listeners.add(listener);
	}
	
	public void start() {
		runner = new Runner();
		new Thread(runner).start();
	}

	public void stop() {
		runner.stop();
	}

	public void waitForTermination() {
		while (runner.isRunning()) {
			try { Thread.sleep(50); } 
			catch (InterruptedException e) { }
		}
	}

	/**
	 * Represents a listener useful to be notified about start, change, termination or stop.
	 */
	public static interface Listener {

		void onStart(CountdownTimer timer);

		void onChange(CountdownTimer timer, long remaining);

		void onTerminate(CountdownTimer timer);

		void onStop(CountdownTimer timer);
		
	}

	private static class Listeners {

		private final List<CountdownTimer.Listener> all;
		private final CountdownTimer timer;

		public Listeners(CountdownTimer timer) {
			super();
			this.timer = timer;
			this.all = new LinkedList<CountdownTimer.Listener>();
		}

		public void add(CountdownTimer.Listener listener) {
			this.all.add(listener);
		}
		
		public void raiseOnStart() {
			for (CountdownTimer.Listener l : all) {
				try { l.onStart(timer); }
				catch (Throwable t) { }
			}
		}

		public void raiseOnChange(long remaining) {
			for (CountdownTimer.Listener l : all) {
				try { l.onChange(timer, remaining); }
				catch (Throwable t) { }
			}
		}

		public void raiseOnTerminate() {
			for (CountdownTimer.Listener l : all) {
				try { l.onTerminate(timer); }
				catch (Throwable t) { }
			}
		}

		public void raiseOnStop() {
			for (CountdownTimer.Listener l : all) {
				try { l.onStop(timer); }
				catch (Throwable t) { }
			}
		}
		
	}
	
	private class Runner implements Runnable {

		private long startedAt;
		private boolean running;
		private boolean stopped;
		private long previousRemaining;
		
		public Runner() {
			super();
			running = true;
			stopped = false;
			previousRemaining = -1;
		}

		public void stop() {
			stopped = true;
		}

		public boolean isRunning() {
			return running;
		}
		
		@Override
		public void run() {
			startedAt = System.currentTimeMillis();
			listeners.raiseOnStart();
			
			long remaining = 0;
			while (! stopped) {
				long elapsed = System.currentTimeMillis() - startedAt;
				remaining = millis - elapsed;
				if (remaining <= 0)
					break;
				
				if (previousRemaining != remaining) {
					previousRemaining = remaining;
					listeners.raiseOnChange(remaining);
				}
				
				try { Thread.sleep(100); } 
				catch (InterruptedException e) { }
			}

			if (stopped)
				listeners.raiseOnStop();
			else if (remaining <= 0)
				listeners.raiseOnTerminate();
			
			running = false;
		}
		
	}

}
