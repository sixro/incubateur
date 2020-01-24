package saver;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class UtilsTest {

	@Test public void returns_expected_types() {
		assertArrayEquals(new Class<?>[]{ Integer.class }, Utils.toParameterTypes(new Object[]{ 2 }));
	}

	@Test public void returns_expected_strings() {
		assertArrayEquals(new String[]{ "2" }, Utils.toStrings(new Object[]{ 2 }));
		assertArrayEquals(new String[]{ "Hello World", "<null>", "5.2" }, Utils.toStrings(new Object[]{ "Hello World", null, new BigDecimal("5.2") }));
	}

}
