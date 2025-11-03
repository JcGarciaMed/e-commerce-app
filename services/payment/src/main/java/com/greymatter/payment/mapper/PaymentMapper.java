package com.greymatter.payment.mapper;

import com.greymatter.payment.dto.PaymentRequest;
import com.greymatter.payment.model.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toPayment(PaymentRequest paymentRequest);
}
