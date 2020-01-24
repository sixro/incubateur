package sixro.powertrade.infrastructure.repository;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sixro.powertrade.domain.Repository;

public class InMemoryRepository implements Repository {

	private static final Logger LOG = LoggerFactory.getLogger(InMemoryRepository.class);

	@Override
	public List<String> findAllWatchlists() {
		return Arrays.asList("FTSE MIB");
	}

	@Override
	public List<String> findStockSymbols(String watchlistName) {
		LOG.info("finding stock symbols in watchlist '{}'...", watchlistName);

		List<String> symbols = Arrays.asList("MS.MI", "LUX.MI");

		LOG.info("... returning {}", symbols);
		return symbols;
	}

}
