package com.sixro.game.armytrainer.core.util;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ViewportUtils {

	private ViewportUtils() { }
	
	public static GridPoint2 pointToCenter(Actor actor, Viewport viewport) {
		return pointToCenter(viewport.getWorldWidth(), viewport.getWorldHeight(), actor.getWidth(), actor.getHeight());
	}

	public static GridPoint2 pointToCenter(float screenWidth, float screenHeight, float componentWidth, float componentHeight) {
		int x = (int) ((screenWidth - componentWidth) /2);
		int y = (int) ((screenHeight - componentHeight) /2);
		return new GridPoint2(x, y);
	}
	
}
