package com.github.sixro.minihabits.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.github.sixro.minihabits.core.MiniHabitsApp;

public class MiniHabitsAppDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 400;
		config.height = 667;
		new LwjglApplication(new MiniHabitsApp(), config);
	}
}
