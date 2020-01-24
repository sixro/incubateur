package sixro.powertrade.domain;

import java.util.List;

public interface Repository {

	List<String> findAllWatchlists();

	List<String> findStockSymbols(String watchlistName);

}
