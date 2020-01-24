package payment4j;

import java.util.Objects;

import javax.money.MonetaryAmount;

/**
 * Represents a payment authorization intent.
 */
public class AuthorizationIntent {

	private final MonetaryAmount amount;

	public AuthorizationIntent(MonetaryAmount amount) {
		super();
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorizationIntent other = (AuthorizationIntent) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthorizationIntent [amount=" + amount + "]";
	}

}
