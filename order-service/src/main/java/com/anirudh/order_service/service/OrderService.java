package com.anirudh.order_service.service;

import com.anirudh.order_service.common.Payment;
import com.anirudh.order_service.common.TransactionRequest;
import com.anirudh.order_service.common.TransactionResponse;
import com.anirudh.order_service.entity.Order;
import com.anirudh.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;


    public String getOrderControllerHealth(){
        return "ORDER SERVICE OK";
    }

    public TransactionResponse saveOrder(TransactionRequest request){

        String response = "";

        Order order = request.getOrder();
        Payment payment = request.getPayment();

        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //TODO: REST CALL

        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        response = paymentResponse.getPaymentStatus().equals("Success") ? "Payment Processing Successfull" : "Failed Payment API, Added Order In Cart";

        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
