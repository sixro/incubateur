package adverth.core;

/**
 * Represents a stock screener.
 */
public class StockScreener {

	public Outcome screen(String ticker, Filter filter) {
		return filter.accept(ticker);
	}
	
}
