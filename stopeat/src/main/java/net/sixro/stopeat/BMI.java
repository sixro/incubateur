package net.sixro.stopeat;

public class BMI {

	public double calculate(int weight, int height) {
		return weight / ((double) Math.pow(height /100d, 2.5));
	}

}
