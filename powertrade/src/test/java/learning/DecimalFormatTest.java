package learning;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.*;
import java.util.Locale;

import org.junit.Test;

public class DecimalFormatTest {

	@Test
	public void test() throws ParseException {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.0###", DecimalFormatSymbols.getInstance(Locale.US));
		decimalFormat.setParseBigDecimal(true);
		BigDecimal value = (BigDecimal) decimalFormat.parse("18,123.45");
		assertEquals(new BigDecimal("18123.45"), value);
	}

}
