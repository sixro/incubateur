package com.sixro.game.armytrainer.html;

import com.sixro.game.armytrainer.core.ArmyTrainerGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class ArmyTrainerGameHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new ArmyTrainerGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
