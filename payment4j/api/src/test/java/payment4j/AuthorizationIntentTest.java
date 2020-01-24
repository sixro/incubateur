package payment4j;

import static org.junit.Assert.*;

import org.javamoney.moneta.Money;
import org.junit.Test;

public class AuthorizationIntentTest {

	@Test
	public void textual_representation() {
		System.out.println(new AuthorizationIntent(Money.parse("EUR 12.34")));
	}

}
