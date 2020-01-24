package adverth.yahoo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class YahooMarketCapProviderTest {

	@Test
	public void return_a_market_cap_value() {
		YahooMarketCapProvider provider = new YahooMarketCapProvider();
		BigDecimal marketCap = provider.getMarketCap("GOOG");
		assertNotNull(marketCap);
	}

}
