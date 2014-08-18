package databaseadapter;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test public void toCamelCase_returnsExpectedValue() {
		assertEquals("CdcCrociera", StringUtils.toCamelCase("cdc_crociera"));
		assertEquals("CdcCrociera", StringUtils.toCamelCase("CDC_CROCIERA"));
	}

}
