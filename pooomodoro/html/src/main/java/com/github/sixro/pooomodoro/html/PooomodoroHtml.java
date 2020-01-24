package com.github.sixro.pooomodoro.html;

import com.github.sixro.pooomodoro.core.Pooomodoro;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class PooomodoroHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Pooomodoro();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
