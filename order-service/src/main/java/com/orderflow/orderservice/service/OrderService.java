package com.orderflow.orderservice.service;

import com.orderflow.orderservice.entity.Order;

public interface OrderService {

    Order createOrder(Order order);

}