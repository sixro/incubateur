package adverth.core;

/**
 * Represents a <a href="https://en.wikipedia.org/wiki/Composite_pattern" target="_top" >COMPOSITE</a> of {@link Filter}.
 */
public class CompositeFilter implements Filter {

	private final Filter[] filters;

	public CompositeFilter(Filter[] filters) {
		this.filters = filters;
	}

	public Filter[] getFilters() {
		return filters;
	}

	@Override
	public Outcome accept(String ticker) {
		for (Filter filter : filters) {
			if (Outcome.ko.equals(filter.accept(ticker)))
				return Outcome.ko;
		}
		return Outcome.ok;
	}

}
