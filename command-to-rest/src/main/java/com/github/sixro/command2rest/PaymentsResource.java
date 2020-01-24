package com.github.sixro.command2rest;

import com.github.sixro.command2rest.domain.PaymentIntent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Consumer;

@RestController
public class PaymentsResource {

    private Consumer<PaymentIntent> createPaymentCommand;

    public PaymentsResource(Consumer<PaymentIntent> createPaymentCommand) {

        this.createPaymentCommand = createPaymentCommand;
    }

    @PostMapping("/payments/{id}")
    public ResponseEntity<Void> create(@PathVariable String id, @RequestBody PaymentIntent intent) throws URISyntaxException {
        intent.setId(id);
        createPaymentCommand.accept(intent);

        return ResponseEntity.created(new URI("/payments/" + id)).build();
    }
}
