package sixro.powertrade.domain;

import java.util.List;

import org.jdeferred.Promise;

public interface FinanceService {

	Promise<List<Stock>, Throwable, Double> findStocks(List<String> stockSymbols);

}
