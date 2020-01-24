package com.github.sixro.pooomodoro.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.sixro.pooomodoro.core.Pooomodoro;

public class PooomodoroDesktop {
	
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 740;
		config.height = 480;
		
		new LwjglApplication(new Pooomodoro(), config);
	}
}
