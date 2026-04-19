package com.orderflow.orderservice.service;

import com.orderflow.orderservice.dto.OrderRequest;
import com.orderflow.orderservice.dto.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

}