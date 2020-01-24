package payment4j;

import java.util.Objects;

import javax.money.MonetaryAmount;

public class Refund {

	static enum Status { PENDING, COMPLETE, DECLINED };

	private final ID id;
	private final MonetaryAmount amount;
	private Refund.Status status;
	
	public Refund(ID id, MonetaryAmount amount) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = Status.PENDING;
	}

	public ID getId() {
		return id;
	}

	public MonetaryAmount getAmount() {
		return amount;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refund other = (Refund) obj;
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
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Refund [id=" + id + ", amount=" + amount + ", status=" + status + "]";
	}

}
