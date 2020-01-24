package sixro.powertrade.domain;

import lombok.Data;

@Data
public class Stock {

	private final String symbol;
	private final String name;
	private final PriceInfo lastPriceInfo;
	private final Book lastBook;

}
