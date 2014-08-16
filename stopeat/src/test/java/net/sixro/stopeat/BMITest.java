package net.sixro.stopeat;

import org.junit.*;

public class BMITest {

	@Test public void returns_expected() {
		BMI bmi = new BMI();
		Assert.assertEquals(16.1, bmi.calculate(70, 180), 0.1);
	}

}
