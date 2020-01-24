package adverth.core.filter;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import adverth.core.Outcome;
import adverth.core.filter.MarketCap.Provider;

public class MarketCapTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Provider provider = context.mock(MarketCap.Provider.class);
	
	@Test
	public void positive() {
		MarketCap marketcap = new MarketCap(provider, "value > 0");

		context.checking(new Expectations() {{ 
			oneOf(provider).getMarketCap("GBX");
				will(returnValue(BigDecimal.ONE));
		}});
		
		assertEquals(Outcome.ok, marketcap.accept("GBX"));
	}

	@Test
	public void negative() {
		MarketCap marketcap = new MarketCap(provider, "value < 0");

		context.checking(new Expectations() {{ 
			oneOf(provider).getMarketCap("GBX");
				will(returnValue(BigDecimal.ONE));
		}});
		
		assertEquals(Outcome.ko, marketcap.accept("GBX"));
	}

}
