package com.orderflow.orderservice.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.orderflow.orderservice.dto.OrderRequest;
import com.orderflow.orderservice.dto.OrderResponse;
import com.orderflow.orderservice.entity.Order;
import com.orderflow.orderservice.enums.OrderStatus;
import com.orderflow.orderservice.enums.PaymentStatus;
import com.orderflow.orderservice.exception.OrderNotFoundException;
import com.orderflow.orderservice.repository.OrderRepository;
import com.orderflow.orderservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order();

        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(request.getTotalPrice());

        order.setOrderNumber(generateOrderNumber());
        order.setStatus(OrderStatus.CREATED);
        order.setPaymentStatus(PaymentStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        OrderResponse response = new OrderResponse();

        response.setOrderNumber(savedOrder.getOrderNumber());
        response.setUserId(savedOrder.getUserId());
        response.setProductId(savedOrder.getProductId());
        response.setQuantity(savedOrder.getQuantity());
        response.setTotalPrice(savedOrder.getTotalPrice());
        response.setStatus(savedOrder.getStatus().name());
        response.setPaymentStatus(savedOrder.getPaymentStatus().name());
        response.setCreatedAt(savedOrder.getCreatedAt());

        return response;
    }

    private String generateOrderNumber() {
        return "ORD-" + System.currentTimeMillis();
    }

    public OrderResponse getOrderByOrderNumber(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new OrderNotFoundException(orderNumber));

        OrderResponse response = new OrderResponse();

        response.setOrderNumber(order.getOrderNumber());
        response.setUserId(order.getUserId());
        response.setProductId(order.getProductId());
        response.setQuantity(order.getQuantity());
        response.setTotalPrice(order.getTotalPrice());
        response.setStatus(order.getStatus().name());
        response.setPaymentStatus(order.getPaymentStatus().name());
        response.setCreatedAt(order.getCreatedAt());

        return response;
    }
}
