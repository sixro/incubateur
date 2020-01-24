package sixro.powertrade.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MarketIndex {

	private final String symbol;
	private final String name;

	private final BigDecimal lastPrice;
	private final BigDecimal percVariation;
	private final BigDecimal volume;

	private final BigDecimal min;
	private final BigDecimal max;

}
