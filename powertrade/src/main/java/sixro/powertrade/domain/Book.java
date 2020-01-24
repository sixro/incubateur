package sixro.powertrade.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Book {

	private final BigDecimal bid;
	private final BigDecimal bidQuantity;
	private final BigDecimal ask;
	private final BigDecimal askQuantity;

}
