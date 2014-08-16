package net.sixro.stopeat.util;

import org.junit.*;
import static org.junit.Assert.*;

public class StringUtilsTest {

	@Test public void isBlank_returns_true_when_text_is_null() {
		assertTrue(StringUtils.isBlank(null));
	}

	@Test public void isBlank_returns_true_when_text_is_empty() {
		assertTrue(StringUtils.isBlank(""));
	}

	@Test public void isBlank_returns_true_when_text_is_blank() {
		assertTrue(StringUtils.isBlank(" \t\r\n"));
	}

	@Test public void anyBlank_returns_true_when_one_of_specified_texts_is_null_or_empty_or_blank() {
		assertTrue(StringUtils.anyBlank(null, "Hello"));
		assertTrue(StringUtils.anyBlank("", "Hello"));
		assertTrue(StringUtils.anyBlank(" ", "Hello"));
		assertTrue(StringUtils.anyBlank("Hello", null));
		assertTrue(StringUtils.anyBlank("Hello", ""));
		assertTrue(StringUtils.anyBlank("Hello", " "));
	}

	@Test public void anyBlank_returns_false() {
		assertFalse(StringUtils.anyBlank("Ciao", "Hello"));
	}

}
