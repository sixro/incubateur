package adverth.yahoo;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adverth.core.MAType;
import adverth.core.TimeFrame;
import adverth.core.filter.CrossingMA.MAProvider;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

public class YahooMAProvider implements MAProvider {

	@Override
	public List<BigDecimal> getMAValues(String ticker, MAType maType, int periods, TimeFrame timeFrame, int lastValues) {
		Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        // FIXME calculate date!
        from.add(Calendar.YEAR, -2); // from 2 years ago
        
		try {
			// FIXME convert timeframe to interval
			Stock stock = retrieveFromYahoo(ticker, from, to);
			List<HistoricalQuote> historicalQuotes = stock.getHistory();
			List<BigDecimal> closePrices = HistoricalQuoteUtils.selectClosePrices(historicalQuotes);
			//System.out.println("CLOSES: " + closePrices);
			List<BigDecimal> maValues = new ArrayList<>(lastValues);
			for (int i = 0; i < lastValues; i++) {
				BigDecimal maval = maType.calculate(closePrices.subList(i, i +periods));
				maValues.add(maval);
			}
			//System.out.println("MA: " + maValues);
			return maValues;
		} catch (IOException e) {
			throw new RuntimeException("Unable to retrieve MA values of \"" + ticker + "\"", e);
		}
	}

	private Stock retrieveFromYahoo(String ticker, Calendar from, Calendar to) throws IOException {
		boolean retry = true;
		Stock stock = null;
		while (retry) {
			retry = false;
			try {
				stock = YahooFinance.get(ticker, from, to, Interval.WEEKLY);
			} catch (SocketTimeoutException | UnknownHostException e) {
				try { Thread.sleep(3 * 1000); } 
				catch (InterruptedException ignore) { }

				retry = true;
			}
		}
		return stock;
	}

}
