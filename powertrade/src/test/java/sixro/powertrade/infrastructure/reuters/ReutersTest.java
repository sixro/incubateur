package sixro.powertrade.infrastructure.reuters;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import sixro.powertrade.domain.MarketIndex;

public class ReutersTest {

	@Test public void create_market_index() throws IOException {
		Document document = Jsoup.parse(Reuters.class.getResourceAsStream("/reuters/dji-sample-page.html"), "UTF-8", "http://www.reuters.com/finance/markets/");
		MarketIndex marketIndex = Reuters.toMarketIndex(".DJI", document);
		System.out.println(marketIndex);
		assertEquals("Dow Jones Industrial Average", marketIndex.getName());
		assertEquals(new BigDecimal("18240.49"), marketIndex.getLastPrice());
		assertEquals(new BigDecimal("-0.15"), marketIndex.getPercVariation());
		assertEquals(new BigDecimal("18149.30"), marketIndex.getMin());
		assertEquals(new BigDecimal("18319.70"), marketIndex.getMax());
	}

}
