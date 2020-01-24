package sixro.powertrade.infrastructure.reuters;

import static org.junit.Assert.*;

import org.junit.Test;

import sixro.powertrade.infrastructure.reuters.Reuters.BigDecimalParser;

public class ReutersBigDecimalParser {

	@Test public void empty_for_doubleminus() {
		assertEquals(null, BigDecimalParser.parse("--"));
	}
	
}
