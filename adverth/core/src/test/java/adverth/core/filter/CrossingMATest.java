package adverth.core.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import adverth.core.MAType;
import adverth.core.Outcome;
import adverth.core.TimeFrame;
import adverth.core.filter.CrossingMA.MAProvider;

public class CrossingMATest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private MAProvider maProvider = context.mock(MAProvider.class);
	private CrossingMA crossingma = new CrossingMA(
		maProvider, 
		TimeFrame.week, 
		MAType.sma, 30, 
		MAType.sma, 10, 
		2
	);
	
	@Test
	public void positive() {		
		List<BigDecimal> ma1values = toBigDecimals(1, 2);
		List<BigDecimal> ma2values = toBigDecimals(2, 1);
		
		context.checking(new Expectations() {{ 
			oneOf(maProvider).getMAValues("GBX", MAType.sma, 30, TimeFrame.week, 2);
				will(returnValue(ma1values));
			oneOf(maProvider).getMAValues("GBX", MAType.sma, 10, TimeFrame.week, 2);
				will(returnValue(ma2values));
		}});
		
		Assert.assertEquals(Outcome.ok, crossingma.accept("GBX"));
	}

	@Test
	public void negative() {		
		List<BigDecimal> ma1values = toBigDecimals(1, 2);
		List<BigDecimal> ma2values = toBigDecimals(3, 4);
		
		context.checking(new Expectations() {{ 
			oneOf(maProvider).getMAValues("GBX", MAType.sma, 30, TimeFrame.week, 2);
				will(returnValue(ma1values));
			oneOf(maProvider).getMAValues("GBX", MAType.sma, 10, TimeFrame.week, 2);
				will(returnValue(ma2values));
		}});
		
		Assert.assertEquals(Outcome.ko, crossingma.accept("GBX"));
	}

	private static List<BigDecimal> toBigDecimals(Integer... values) {
		List<BigDecimal> array = new ArrayList<>(values.length);
		for (int i = 0; i < values.length; i++) {
			array.add(new BigDecimal(values[i]));
		}
		return array;
	}

}
