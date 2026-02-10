package com.anirudh.order_service.controller;

import com.anirudh.order_service.common.Payment;
import com.anirudh.order_service.common.TransactionRequest;
import com.anirudh.order_service.common.TransactionResponse;
import com.anirudh.order_service.entity.Order;
import com.anirudh.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/health")
    public String getControllerHealth(){
        return orderService.getOrderControllerHealth();
    }

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        return orderService.saveOrder(request);
    }



}
