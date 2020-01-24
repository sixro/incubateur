package sixro.powertrade.infrastructure.financeservice;

import java.util.*;
import java.util.stream.Collectors;

import org.jdeferred.*;
import org.slf4j.*;

import sixro.powertrade.domain.*;
import sixro.powertrade.infrastructure.reuters.Reuters;

public class ReutersMarketIndexProvider implements MarketIndexProvider {

	private static final Logger LOG = LoggerFactory.getLogger(ReutersMarketIndexProvider.class);

	private final DeferredManager dm;
	private final Reuters reuters;

	public ReutersMarketIndexProvider(DeferredManager dm) {
		this(dm, new Reuters());
	}

	public ReutersMarketIndexProvider(DeferredManager dm, Reuters reuters) {
		super();
		this.dm = dm;
		this.reuters = reuters;
	}

	@Override
	public Promise<List<MarketIndex>, Throwable, Double> findAll() {
		DeferredCallable<List<MarketIndex>,Double> callable = new DeferredCallable<List<MarketIndex>, Double>() {
			@Override
			public List<MarketIndex> call() throws Exception {
				LOG.info("Finding all market indices...");

				List<String> symbols = reuters
					.symbols()
					.collect(Collectors.toList());

				List<MarketIndex> list = Collections.synchronizedList(new LinkedList<>());
				symbols
					.parallelStream()
					.forEach(i -> {
						list.add(reuters.marketIndex(i));
						notify(((double) list.size()) /symbols.size());
					});

				return list;
			}
		};
		return dm.when(callable);
	}

}
