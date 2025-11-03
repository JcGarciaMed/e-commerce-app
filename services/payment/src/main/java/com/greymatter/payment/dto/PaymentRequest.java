package com.greymatter.payment.dto;

import com.greymatter.payment.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerDto customer
) {
}
