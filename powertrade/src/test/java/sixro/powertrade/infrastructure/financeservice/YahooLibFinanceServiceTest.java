package sixro.powertrade.infrastructure.financeservice;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import sixro.powertrade.domain.*;
import yahoofinance.quotes.stock.*;

public class YahooLibFinanceServiceTest {

	@Test
	public void create_stock() {
		yahoofinance.Stock yahooFinanceStock = new yahoofinance.Stock("MS.MI");
		yahooFinanceStock.setName("Mediaset");

		StockQuote quote = new StockQuote("MS.MI");
		quote.setPrice(BigDecimal.ONE);
		quote.setPreviousClose(BigDecimal.TEN);
		quote.setAvgVolume(10L);
		quote.setAsk(new BigDecimal(2));
		quote.setAskSize(3L);
		quote.setBid(new BigDecimal(4));
		quote.setBidSize(5L);

		yahooFinanceStock.setQuote(quote);

		Stock stock = YahooLibFinanceService.toStock(yahooFinanceStock);
		assertEquals("MS.MI", stock.getSymbol());
		assertEquals("Mediaset", stock.getName());
		assertEquals(new PriceInfo(BigDecimal.ONE, new BigDecimal("-90.00"), BigDecimal.TEN), stock.getLastPriceInfo());
		assertEquals(new Book(BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(2), BigDecimal.valueOf(3)), stock.getLastBook());
	}

}
