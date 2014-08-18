package propertiesutils;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.Properties;

import org.junit.Test;

import propertiesutils.PropertiesUtils.CopyMode;

public class PropertiesUtilsTest {

	private static final String NEW_LINE = System.getProperty("line.separator");

	@Test public void returns_sub_properties() {
		Properties props = new Properties();
		props.setProperty("a.x", "1");
		props.setProperty("b.x", "2");
		Properties subprops = PropertiesUtils.subProperties(props, "a");
		assertEquals("1", subprops.getProperty("x"));
	}

	@Test public void list_ordered() {
		Properties props = new Properties();
		props.setProperty("b", "2");
		props.setProperty("a", "1");
		props.setProperty("c", "3");
		
		StringWriter writer = new StringWriter();
		PropertiesUtils.listOrdered(props, writer);
		assertTrue(writer.toString().startsWith("a=1" + NEW_LINE));
		assertTrue(writer.toString().endsWith(NEW_LINE + "c=3"));
	}

	@Test public void copy_overwrite_existing() {
		Properties source = new Properties();
		source.setProperty("a", "1");

		Properties dest = new Properties();
		dest.setProperty("a", "0");

		PropertiesUtils.copy(source, dest, CopyMode.overwrite);
		assertEquals("1", dest.getProperty("a"));
	}

	@Test public void copy_skip_existing() {
		Properties source = new Properties();
		source.setProperty("a", "1");

		Properties dest = new Properties();
		dest.setProperty("a", "0");

		PropertiesUtils.copy(source, dest, CopyMode.dont_overwrite);
		assertEquals("0", dest.getProperty("a"));
	}

	@Test public void copy_to_system_properties_too() {
		System.clearProperty("a");
		assertNull(System.getProperty("a"));
		
		Properties source = new Properties();
		source.setProperty("a", "1");

		PropertiesUtils.copy(source, System.getProperties(), CopyMode.dont_overwrite);
		assertEquals("1", System.getProperty("a"));
	}

}
