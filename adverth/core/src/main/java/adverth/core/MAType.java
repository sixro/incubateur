package adverth.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public enum MAType {

	sma,
	ema;
	
	public BigDecimal calculate(List<BigDecimal> values) {
		// FIXME calculate other types of MA... this is only SMA
		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal v : values)
			sum = sum.add(v);
		//System.out.println("Dividing " + sum + " by " +  values.size() + "...");
		return sum.divide(new BigDecimal(values.size()), 2, RoundingMode.HALF_UP);
	}
	
}
