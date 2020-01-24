package adverth.yahoo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import adverth.core.MAType;
import adverth.core.TimeFrame;

public class YahooMAProviderTest {

	@Test
	public void expected_values() {
		YahooMAProvider provider = new YahooMAProvider();
		List<BigDecimal> maValues = provider.getMAValues("GOOG", MAType.sma, 30, TimeFrame.week, 10);
		assertEquals(10, maValues.size());
		System.out.println(maValues);
	}

}
