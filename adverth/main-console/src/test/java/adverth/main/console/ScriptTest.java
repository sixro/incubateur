package adverth.main.console;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import adverth.core.CompositeFilter;
import adverth.core.Filter;
import adverth.core.MAType;
import adverth.core.TimeFrame;
import adverth.core.filter.CrossingMA;
import adverth.core.filter.MarketCap;

public class ScriptTest {

	private Script script = new Script(new File("./src/test/resources/myscript.txt"));

	@Test
	public void always_composite_filter() {
		Filter filter = script.toFilters();
		assertTrue(filter instanceof CompositeFilter);
		CompositeFilter composite = (CompositeFilter) filter;
		assertTrue(composite.getFilters()[0] instanceof MarketCap);
		assertTrue(composite.getFilters()[1] instanceof CrossingMA);
	}

	@Test
	public void parse_return_marketcap() {
		Filter filter = Script.parse("market_cap \"value > 500000000\"");
		assertTrue(filter instanceof MarketCap);
		MarketCap marketcap = (MarketCap) filter;
		assertEquals("value > 500000000", marketcap.getExpression());
	}

	@Test
	public void parse_return_crossing_ma() {
		Filter filter = Script.parse("crossing_ma week sma 30 sma 10 5");
		assertTrue(filter instanceof CrossingMA);
		CrossingMA crossingma = (CrossingMA) filter;
		assertEquals(TimeFrame.week, crossingma.getTimeFrame());
		assertEquals(MAType.sma, crossingma.getFirstMAType());
		assertEquals(30, crossingma.getFirstMAPeriods());
		assertEquals(MAType.sma, crossingma.getSecondMAType());
		assertEquals(10, crossingma.getSecondMAPeriods());
		assertEquals(5, crossingma.getLastPeriods());
	}
	
}
