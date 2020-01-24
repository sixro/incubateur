package com.github.sixro.pooomodoro.core;

import com.badlogic.gdx.Game;

public class Pooomodoro extends Game {

	private MainScreen mainScreen;
	
	@Override
	public void create () {
		mainScreen = new MainScreen();
		setScreen(mainScreen);
	}

}
