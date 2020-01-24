package sixro.powertrade.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PriceInfo {

	private final BigDecimal price;
	private final BigDecimal variation;
	private final BigDecimal volume;

}
