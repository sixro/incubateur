package adverth.core;

public class FixedNegativeFilter implements Filter {

	@Override
	public Outcome accept(String ticker) {
		return Outcome.ko;
	}

}
