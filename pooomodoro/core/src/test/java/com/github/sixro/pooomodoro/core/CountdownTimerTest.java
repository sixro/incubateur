package com.github.sixro.pooomodoro.core;

import static org.junit.Assert.*;

import org.junit.*;

public class CountdownTimerTest implements CountdownTimer.Listener {

	private boolean started;
	private int countOfChanges;
	private boolean terminated;
	private boolean stopped;

	@Before public void setup() {
		started = false;
		countOfChanges = 0;
		terminated = false;
		stopped = false;
	}
	
	@Test
	public void notifyStart() {
		CountdownTimer timer = new CountdownTimer(100);
		timer.addListener(this);
		timer.start();

		waitForAWhile();
		
		assertTrue(started);
	}

	@Test
	public void notifyChange() {
		CountdownTimer timer = new CountdownTimer(1000);
		timer.addListener(this);
		timer.start();
		
		timer.waitForTermination();
		
		assertTrue(countOfChanges > 0);
	}

	@Test
	public void notifyTermination() {
		CountdownTimer timer = new CountdownTimer(1000);
		timer.addListener(this);
		timer.start();
		timer.waitForTermination();
		assertTrue(terminated);
	}

	@Test
	public void notifyStop() {
		CountdownTimer timer = new CountdownTimer(3000);
		timer.addListener(this);
		timer.start();
		
		waitForAWhile();
		
		timer.stop();

		waitForAWhile();
		
		assertTrue(stopped);
	}

	@Override
	public void onStart(CountdownTimer timer) {
		started = true;
	}

	@Override
	public void onChange(CountdownTimer timer, long remaining) {
		countOfChanges++;
	}

	@Override
	public void onTerminate(CountdownTimer timer) {
		terminated = true;
	}

	@Override
	public void onStop(CountdownTimer timer) {
		stopped = true;
	}

	private void waitForAWhile() {
		try { Thread.sleep(200); } 
		catch (InterruptedException e) { }
	}
	
}
