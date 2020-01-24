package net.sixro.util;

/**
 * Represents a set of math utilities. 
 */
public class MathUtils {

	private MathUtils() { }
	
	/**
	 * Returns a rounded value near the specified step.
	 * 
	 * <p>
	 * E.g. {@code MathUtils(2, 20)} returns {@code 0}, {@code MathUtils(12, 20)} returns {@code 20}, etc... 
	 * </p>
	 * 
	 * @param value a value
	 * @param step a step
	 * @return rounded value near the specified step
	 */
	public static int round(int value, int step) {
		int roundDownOrUp = (int) Math.round(((double) (value % step)) / step);
		int result = ((int) (value / step)) * step;
		if (roundDownOrUp != 0)
			result += roundDownOrUp * step;
		return result;
	}

}
