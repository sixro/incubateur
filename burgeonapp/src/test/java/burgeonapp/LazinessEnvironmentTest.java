package burgeonapp;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;
import org.springframework.core.env.Environment;

public class LazinessEnvironmentTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Environment environment = context.mock(Environment.class);
	private LazinessEnvironment lazinessEnv = new LazinessEnvironment(environment);
	
	@Test
	public void simple_property() {
		context.checking(new Expectations() {{ 
			oneOf(environment).getProperty("simple-property");
				will(returnValue("hello-world"));
		}});
		
		assertEquals("hello-world", lazinessEnv.getProperty("simple-property"));
	}

	@Test
	public void laziness_one_level() {
		context.checking(new Expectations() {{ 
			oneOf(environment).getProperty("useless.required-property");
				will(returnValue(null));
			oneOf(environment).getProperty("required-property");
				will(returnValue("found"));
		}});
		
		assertEquals("found", lazinessEnv.getProperty("useless.required-property"));
	}

	@Test
	public void laziness_complex_props() {
		context.checking(new Expectations() {{ 
			oneOf(environment).getProperty("options.customers.retrieve-sql");
				will(returnValue(null));
			oneOf(environment).getProperty("options.retrieve-sql");
				will(returnValue(null));
			oneOf(environment).getProperty("retrieve-sql");
				will(returnValue("found"));
		}});
		
		assertEquals("found", lazinessEnv.getProperty("options.customers.retrieve-sql"));
	}

	@Test
	public void found_lazy_props() {
		context.checking(new Expectations() {{ 
			oneOf(environment).getProperty("options.customers.retrieve-sql");
				will(returnValue(null));
			oneOf(environment).getProperty("options.retrieve-sql");
				will(returnValue(null));
			oneOf(environment).getProperty("retrieve-sql");
				will(returnValue("found"));
		}});
		
		assertTrue(lazinessEnv.containsProperty("options.customers.retrieve-sql"));
	}

}
