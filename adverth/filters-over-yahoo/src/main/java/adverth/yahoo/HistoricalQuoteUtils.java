package adverth.yahoo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import yahoofinance.histquotes.HistoricalQuote;

public class HistoricalQuoteUtils {

	private HistoricalQuoteUtils() { }
	
	public static List<BigDecimal> selectClosePrices(List<HistoricalQuote> historicalQuotes) {
		List<BigDecimal> closes = new ArrayList<>(historicalQuotes.size());
		for (HistoricalQuote q : historicalQuotes) {
			closes.add(q.getClose());
		}
		return closes;
	}
	
	public static HistoricalQuote newOHLC(int open, int high, int low, int close) {
		HistoricalQuote quote = new HistoricalQuote();
		quote.setOpen(new BigDecimal(open));
		quote.setHigh(new BigDecimal(high));
		quote.setLow(new BigDecimal(low));
		quote.setClose(new BigDecimal(close));
		return quote;
	}

}
