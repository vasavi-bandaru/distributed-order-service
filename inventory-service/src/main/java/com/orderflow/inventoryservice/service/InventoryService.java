package com.orderflow.inventoryservice.service;

import java.util.Optional;

import com.orderflow.inventoryservice.entity.Inventory;

public interface InventoryService {

    Optional<Inventory> getByProductId(Long productId);

    void reduceStock(Long productId, int quantity);
}