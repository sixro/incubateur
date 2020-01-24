package payment4j;

import javax.money.MonetaryAmount;

/**
 * Represents a payment gateway able to handle all payment operations.
 */
public interface PaymentGateway {

	Authorization authorize(AuthorizationIntent authorizationIntent) throws PaymentGatewayException;
	
	void cancel(ID authorizationID) throws PaymentGatewayException;

	void capture(ID authorizationID, MonetaryAmount amount) throws PaymentGatewayException;
	
	Refund refund(ID captureID, MonetaryAmount amount) throws PaymentGatewayException;

}
