package com.orderflow.orderservice.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.orderflow.orderservice.entity.Order;
import com.orderflow.orderservice.enums.OrderStatus;
import com.orderflow.orderservice.enums.PaymentStatus;
import com.orderflow.orderservice.repository.OrderRepository;
import com.orderflow.orderservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {

        //Generate order number
        order.setOrderNumber(generateOrderNumber());

        //Set default values
        order.setStatus(OrderStatus.CREATED);
        order.setPaymentStatus(PaymentStatus.PENDING);

        //Set timestamps
        order.setCreatedAt(LocalDateTime.now());

        //Save to DB
        return orderRepository.save(order);
    }

    private String generateOrderNumber() {
        return "ORD-" + System.currentTimeMillis();
    }
}
