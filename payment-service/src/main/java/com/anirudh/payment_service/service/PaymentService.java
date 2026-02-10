package com.anirudh.payment_service.service;

import com.anirudh.payment_service.entity.Payment;
import com.anirudh.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public String paymentProcessing(){
        // This Call should come from third-party payment gateway, mocking this for project purposes.
        return new Random().nextBoolean()?"Success":"Failed";
    }

    public String getServiceControllerHealth(){
        return "PAYMENT SERVICE OK";
    }

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }
}
