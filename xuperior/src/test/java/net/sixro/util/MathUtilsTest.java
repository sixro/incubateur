package net.sixro.util;

import static org.junit.Assert.*;
import net.sixro.util.MathUtils;

import org.junit.Test;

public class MathUtilsTest {

	@Test public void round_returns_an_int_rounded_at_specified_step() {
		assertEquals(0, MathUtils.round(1, 20));
		assertEquals(20, MathUtils.round(18, 20));
		assertEquals(20, MathUtils.round(22, 20));
		assertEquals(40, MathUtils.round(35, 20));
		assertEquals(40, MathUtils.round(30, 20));
		assertEquals(0, MathUtils.round(-5, 20));
		assertEquals(-20, MathUtils.round(-17, 20));
	}
	
}
