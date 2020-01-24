package sixro.powertrade.domain;

import java.util.List;

import org.jdeferred.Promise;

public interface MarketIndexProvider {

	Promise<List<MarketIndex>, Throwable, Double> findAll();

}
