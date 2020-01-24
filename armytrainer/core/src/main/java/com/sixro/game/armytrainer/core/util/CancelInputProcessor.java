package com.sixro.game.armytrainer.core.util;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;

/**
 * Represents an input processor of what is represented as a cancellation (e.g. ESC key, BACK key, etc...).
 */
public class CancelInputProcessor extends InputAdapter {

	private final Runnable action;

	public CancelInputProcessor(Runnable action) {
		this.action = action;
	}

	@Override
	public boolean keyDown(int keycode) {
		Gdx.app.log("CancelInputProcessor", "key is " + keycode + " ...");
		if (keycode != Keys.ESCAPE && keycode != Keys.BACK)
			return false;
		
		Gdx.app.log("CancelInputProcessor", "... handling ESC or BACK");
		Gdx.app.postRunnable(action);
		return true;
	}

}
