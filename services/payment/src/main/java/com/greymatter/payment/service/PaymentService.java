package com.greymatter.payment.service;

import com.greymatter.payment.dto.PaymentRequest;
import com.greymatter.payment.mapper.PaymentMapper;
import com.greymatter.payment.notification.NotificationProducer;
import com.greymatter.payment.notification.PaymentNotificationRequest;
import com.greymatter.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = this.repository.save(this.mapper.toPayment(request));
        sendNotification(request);
        return payment.getId();
    }

    private void sendNotification(PaymentRequest notificationRequest) {
        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        notificationRequest.orderReference(),
                        notificationRequest.amount(),
                        notificationRequest.paymentMethod(),
                        notificationRequest.customer().firstname(),
                        notificationRequest.customer().lastname(),
                        notificationRequest.customer().email()
                )
        );
    }
}
