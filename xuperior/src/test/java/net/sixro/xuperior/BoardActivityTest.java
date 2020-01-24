package net.sixro.xuperior;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardActivityTest {

	@Test public void playerRotation_returns_40() {
		assertEquals(40, BoardActivity.playerRotation(40, 0));
	}

	@Test public void playerRotation_returns_50() {
		assertEquals(50, BoardActivity.playerRotation(-178, 132));
	}

	@Test public void playerRotation_returns_FIXME() {
		assertEquals(167, BoardActivity.playerRotation(179, -14));
	}

}
