package adverth.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockScreenerTest {

	@Test
	public void positive_screening() {
		StockScreener screener = new StockScreener();
		assertEquals(Outcome.ok, screener.screen("GBX", new FixedPositiveFilter()));
	}

	@Test
	public void negative_screening() {
		StockScreener screener = new StockScreener();
		assertEquals(Outcome.ko, screener.screen("GBX", new FixedNegativeFilter()));
	}
	
}
