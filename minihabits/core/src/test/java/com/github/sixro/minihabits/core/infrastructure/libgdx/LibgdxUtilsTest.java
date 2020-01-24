package com.github.sixro.minihabits.core.infrastructure.libgdx;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibgdxUtilsTest {

	@Test
	public void no_libgdx_environment() {
		assertFalse(LibgdxUtils.isLibgdxEnvironment());
	}

}
