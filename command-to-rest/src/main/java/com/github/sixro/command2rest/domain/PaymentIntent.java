package com.github.sixro.command2rest.domain;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class PaymentIntent {

    private final BigDecimal amount;
    private final Currency currency;

    private String id;

}
