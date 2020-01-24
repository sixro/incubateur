package adverth.core;

/**
 * Represents a filter of a stock.
 */
public interface Filter {

	Outcome accept(String ticker);

}
