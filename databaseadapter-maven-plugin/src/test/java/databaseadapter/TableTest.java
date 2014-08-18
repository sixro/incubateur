package databaseadapter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest {

	@Test public void named_returnsTrue() {
		Table table = new Table("CDC_CROCIERA");
		assertTrue(table.named("CDC_CROCIERA"));
		assertTrue(table.named("cdc_crociera"));
	}

}
