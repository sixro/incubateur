package payment4j;

import java.util.Objects;

import javax.money.MonetaryAmount;

/**
 * Represents a payment authorization.
 */
public class Authorization {
	
	static enum Status { PENDING, AUTHORIZED, CAPTURED, DECLINED };
	
	private final ID id;
	private final MonetaryAmount amount;
	private Authorization.Status status;
	
	public Authorization(ID id, MonetaryAmount amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public ID getId() {
		return id;
	}

	public MonetaryAmount getAmount() {
		return amount;
	}

	public Authorization.Status getStatus() {
		return status;
	}

	public void setStatus(Authorization.Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authorization other = (Authorization) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authorization [id=" + id + ", amount=" + amount + ", status=" + status + "]";
	}

}
