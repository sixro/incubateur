package com.github.sixro.command2rest;

import com.github.sixro.command2rest.domain.PaymentIntent;
import org.jmock.Expectations;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Currency;
import java.util.function.Consumer;

public class PaymentsResourceTest {

    @RegisterExtension
    public JUnit5Mockery context = new JUnit5Mockery();
    private Consumer createPaymentCommand = context.mock(Consumer.class);
    private PaymentsResource resource = new PaymentsResource(createPaymentCommand);

    @Test public void delegate() throws URISyntaxException {
        PaymentIntent intent = new PaymentIntent(BigDecimal.TEN, Currency.getInstance("EUR"));
        context.checking(new Expectations() {{
            oneOf(createPaymentCommand).accept(intent);
        }});
        resource.create("MYPAYMENT-1234", intent);
    }

}