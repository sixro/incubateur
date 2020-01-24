package com.sixro.game.armytrainer.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.sixro.game.armytrainer.core.ArmyTrainerGame;

public class ArmyTrainerGameDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 420;
		config.height = (int) (config.width * (((double) (800)) / 480));
		config.title = "Army Trainer";

		new LwjglApplication(new ArmyTrainerGame(), config);
	}
}
