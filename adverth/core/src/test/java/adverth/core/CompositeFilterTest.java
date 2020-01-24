package adverth.core;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CompositeFilterTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Filter filter1 = context.mock(Filter.class, "filter1");
	private Filter filter2 = context.mock(Filter.class, "filter2");
	
	@Test
	public void positive() {
		CompositeFilter compositefilter = new CompositeFilter(new Filter[]{ filter1, filter2 });
		
		context.checking(new Expectations() {{ 
			oneOf(filter1).accept("GBX");
				will(returnValue(Outcome.ok));
			oneOf(filter2).accept("GBX");
				will(returnValue(Outcome.ok));
		}});
		
		assertEquals(Outcome.ok, compositefilter.accept("GBX"));
	}

	@Test
	public void negative_at_first_filter() {
		CompositeFilter compositefilter = new CompositeFilter(new Filter[]{ filter1, filter2 });
		
		context.checking(new Expectations() {{ 
			oneOf(filter1).accept("GBX");
				will(returnValue(Outcome.ko));
		}});
		
		assertEquals(Outcome.ko, compositefilter.accept("GBX"));
	}

	@Test
	public void negative_at_last_filter() {
		CompositeFilter compositefilter = new CompositeFilter(new Filter[]{ filter1, filter2 });
		
		context.checking(new Expectations() {{ 
			oneOf(filter1).accept("GBX");
				will(returnValue(Outcome.ok));
			oneOf(filter2).accept("GBX");
				will(returnValue(Outcome.ko));
		}});
		
		assertEquals(Outcome.ko, compositefilter.accept("GBX"));
	}

}
