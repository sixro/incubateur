package adverth.yahoo;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import adverth.core.filter.MarketCap;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class YahooMarketCapProvider implements MarketCap.Provider {

	@Override
	public BigDecimal getMarketCap(String ticker) {
		try {
			Stock stock = getFromYahoo(ticker);
			return stock.getStats().getMarketCap();
		} catch (IOException e) {
			throw new RuntimeException("Unable to retrieve market cap value of '" + ticker + "' using Yahoo Finance API", e);
		}
	}

	private Stock getFromYahoo(String ticker) throws IOException {
		boolean retry = true;
		Stock stock = null;
		while (retry) {
			retry = false;
			try {
				stock = YahooFinance.get(ticker);
			} catch (SocketTimeoutException | UnknownHostException e) {
				try { Thread.sleep(3 * 1000); } 
				catch (InterruptedException ignore) { }

				retry = true;
			}
		}
		return stock;
	}

}
