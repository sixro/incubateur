package adverth.core.filter;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import adverth.core.Filter;
import adverth.core.Outcome;

/**
 * Represents a filter based on
 * <a href="https://en.wikipedia.org/wiki/Market_capitalization" 
 * 	target="_top">Market Capitalization</a>.
 * 
 * <p>
 * An example of <i>expression</i> is the following:
 * </p>
 * <pre>
 * 	value > 500000000
 * </pre>
 */
public class MarketCap implements Filter {

	private final Provider provider;
	private final String expression;

	private final ScriptEngine engine;

	public MarketCap(MarketCap.Provider provider, String expression) {
		super();
		this.provider = provider;
		this.expression = expression;

		ScriptEngineManager manager = new ScriptEngineManager();
		engine = manager.getEngineByName("js");
	}

	public String getExpression() {
		return expression;
	}

	@Override
	public Outcome accept(String ticker) {
		BigDecimal value = provider.getMarketCap(ticker);
		engine.put("value", value);
		try {
			Boolean result = (Boolean) engine.eval(expression);
			if (result == null)
				throw new IllegalArgumentException("expression \"" + expression + "\" should return a boolean result");
			return result ? Outcome.ok : Outcome.ko;
		} catch (ScriptException e) {
			throw new RuntimeException(
				"Unable to evaluate expression \"" + expression + "\" with value " + value + " due to a "
					+ e.getClass().getName() + " with message \"" + e.getMessage() + "\". Follows details:",
					e);
		}
	}

	/**
	 * Represents a provider of the market cap value.
	 */
	public static interface Provider {

		BigDecimal getMarketCap(String ticker);

	}

}
