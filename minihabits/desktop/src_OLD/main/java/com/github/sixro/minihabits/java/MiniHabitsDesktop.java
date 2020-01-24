package com.github.sixro.minihabits.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.github.sixro.minihabits.core.MiniHabits;
import com.github.sixro.minihabits.core.util.libgdx.text.JavaDateTimeFormatter;

public class MiniHabitsDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 400;
		config.height = 667;
		new LwjglApplication(new MiniHabits(new JavaDateTimeFormatter()), config);
	}
}
