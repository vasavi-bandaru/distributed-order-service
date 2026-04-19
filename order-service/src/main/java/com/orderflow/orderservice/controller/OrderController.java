package com.orderflow.orderservice.controller;

import com.orderflow.orderservice.dto.OrderRequest;
import com.orderflow.orderservice.dto.OrderResponse;
import com.orderflow.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
}