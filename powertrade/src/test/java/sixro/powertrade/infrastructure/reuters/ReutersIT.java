package sixro.powertrade.infrastructure.reuters;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import sixro.powertrade.domain.MarketIndex;

public class ReutersIT {

	@Test public void symbols() throws IOException {
		Reuters r = new Reuters();
		List<String> symbols = r.symbols()
			.collect(Collectors.toList());
		assertTrue(symbols.size() > 0);
	}

	@Test public void market_index_with_name() throws IOException {
		Reuters r = new Reuters();
		MarketIndex marketIndex = r.marketIndex(".DJI");
		assertEquals("Dow Jones Industrial Average", marketIndex.getName());
		assertEquals(1, marketIndex.getLastPrice().compareTo(BigDecimal.ZERO));
		assertNotNull(marketIndex.getPercVariation());
		assertEquals(1, marketIndex.getMin().compareTo(BigDecimal.ZERO));
		assertEquals(1, marketIndex.getMax().compareTo(BigDecimal.ZERO));
	}

}
