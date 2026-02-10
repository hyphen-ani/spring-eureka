package com.anirudh.payment_service.controller;

import com.anirudh.payment_service.entity.Payment;
import com.anirudh.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/health")
    public String getPaymentControllerHealth() {
        return paymentService.getServiceControllerHealth();
    }

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }


}
