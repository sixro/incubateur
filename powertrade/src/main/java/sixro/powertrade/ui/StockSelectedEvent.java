package sixro.powertrade.ui;

import java.util.EventObject;

public class StockSelectedEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	private final String stockSymbol;

	public StockSelectedEvent(Object source, String stockSymbol) {
		super(source);
		this.stockSymbol = stockSymbol;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	@Override
	public String toString() {
		return "StockSelectedEvent [stockSymbol=" + stockSymbol + "]";
	}

}
