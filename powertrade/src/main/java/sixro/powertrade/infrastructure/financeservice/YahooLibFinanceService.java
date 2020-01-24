package sixro.powertrade.infrastructure.financeservice;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import org.jdeferred.*;
import org.slf4j.*;

import sixro.powertrade.domain.*;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

public class YahooLibFinanceService implements FinanceService {

	private static final Logger LOG = LoggerFactory.getLogger(YahooLibFinanceService.class);

	private final DeferredManager deferredManager;

	public YahooLibFinanceService(DeferredManager deferredManager) {
		super();
		this.deferredManager = deferredManager;
	}

	@Override
	public Promise<List<Stock>, Throwable, Double> findStocks(List<String> stockSymbols) {
		DeferredCallable<List<Stock>, Double> callable = new DeferredCallable<List<Stock>, Double>() {
			@Override
			public List<Stock> call() throws Exception {
				try {
					LOG.info("retrieving stocks about symbols {} ...", stockSymbols);

					Map<String, yahoofinance.Stock> stocksBySymbol = YahooFinance.get(stockSymbols.toArray(new String[0]));
					List<Stock> stocks = new ArrayList<>(stocksBySymbol.size());
					for (String symbol : stockSymbols) {
						yahoofinance.Stock yahooFinanceStock = stocksBySymbol.get(symbol);
						stocks.add(toStock(yahooFinanceStock));
					}

					LOG.info("... returning {} stocks", stocks.size());
					LOG.debug("... and they are: {}", stocks);
					return stocks;
				} catch (IOException e) {
					throw new RuntimeException("Unable to retrieve stocks about symbols " + stockSymbols + " due to " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
				}
			}
		};
		return deferredManager.when(callable);
	}

	static Stock toStock(yahoofinance.Stock yahooFinanceStock) {
		StockQuote quote = yahooFinanceStock.getQuote();
		return new Stock(
			yahooFinanceStock.getSymbol(),
			yahooFinanceStock.getName(),
			new PriceInfo(
				quote.getPrice(),
				quote.getChangeInPercent(),
				nullSafe(quote.getAvgVolume())),
			new Book(
				quote.getBid(),
				nullSafe(quote.getBidSize()),
				quote.getAsk(),
				nullSafe(quote.getAskSize())));
	}

	private static BigDecimal nullSafe(Long avgVolume) {
		return avgVolume != null ? BigDecimal.valueOf(avgVolume) : null;
	}

}
