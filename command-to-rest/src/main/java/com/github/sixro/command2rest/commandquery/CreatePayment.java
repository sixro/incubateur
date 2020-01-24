package com.github.sixro.command2rest.commandquery;

import com.github.sixro.command2rest.domain.PaymentIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class CreatePayment implements Consumer<PaymentIntent> {
    private static final Logger LOG = LoggerFactory.getLogger(CreatePayment.class);

    @Override
    public void accept(PaymentIntent paymentIntent) {
        LOG.info("Creating payment based on {} ...", paymentIntent);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            LOG.error("Interrupted!", e);
        }

        LOG.info("... OK, payment based on {} created", paymentIntent);
    }
}
