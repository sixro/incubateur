package adverth.core;

public class FixedPositiveFilter implements Filter {

	@Override
	public Outcome accept(String ticker) {
		return Outcome.ok;
	}

}
