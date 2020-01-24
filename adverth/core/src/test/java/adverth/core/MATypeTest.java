package adverth.core;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MATypeTest {

	@Test
	public void sma() {
		List<BigDecimal> values = Arrays.asList(
			BigDecimal.valueOf(2),
			BigDecimal.valueOf(4)
		);
		assertEquals(new BigDecimal("3.00"), MAType.sma.calculate(values));
	}

}
