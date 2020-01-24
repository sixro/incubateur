package payment4j;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an identifier of a specific payment operation provided by the payment gateway.
 */
public final class ID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String value;

	private ID(String value) {
		super();
		this.value = value;
	}

	public static ID valueOf(String value) {
		Objects.requireNonNull(value);
		return new ID(value);
	}
	
	public String toValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ID other = (ID) obj;
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return value;
	}
	
}