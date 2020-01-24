package adverth.yahoo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import yahoofinance.histquotes.HistoricalQuote;

public class HistoricalQuoteUtilsTest {

	@Test
	public void close_price() {
		List<HistoricalQuote> historicalQuotes = Arrays.asList(
			HistoricalQuoteUtils.newOHLC(0, 3, 2, 1),
			HistoricalQuoteUtils.newOHLC(9, 8, 7, 10)
		);
		List<BigDecimal> closePrices = HistoricalQuoteUtils.selectClosePrices(historicalQuotes);
		assertEquals(2, closePrices.size());
		assertEquals(BigDecimal.ONE, closePrices.get(0));
		assertEquals(BigDecimal.TEN, closePrices.get(1));
	}

}
