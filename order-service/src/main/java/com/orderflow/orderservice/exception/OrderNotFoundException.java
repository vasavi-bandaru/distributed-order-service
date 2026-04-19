package com.orderflow.orderservice.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String orderNumber) {
        super("Order not found with orderNumber: " + orderNumber);
    }
}