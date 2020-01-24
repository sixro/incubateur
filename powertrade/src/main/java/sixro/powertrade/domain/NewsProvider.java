package sixro.powertrade.domain;

import java.util.List;

import org.jdeferred.Promise;

public interface NewsProvider {

	Promise<List<PieceOfNews>, Throwable, Void> findNews(String stockSymbol);
	
}
