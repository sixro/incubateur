package com.sixro.game.armytrainer.core.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.GridPoint2;

public class ViewportUtilsTest {

	@Test
	public void pointToCenter_returns_expected() {
		GridPoint2 point = ViewportUtils.pointToCenter(480, 800, 350, 500);
		assertEquals(65, point.x);
		assertEquals(150, point.y);
	}

}
