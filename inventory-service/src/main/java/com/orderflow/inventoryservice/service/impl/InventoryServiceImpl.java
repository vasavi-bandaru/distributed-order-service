package com.orderflow.inventoryservice.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.orderflow.inventoryservice.entity.Inventory;
import com.orderflow.inventoryservice.repository.InventoryRepository;
import com.orderflow.inventoryservice.service.InventoryService;

import jakarta.transaction.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Optional<Inventory> getByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @Override
    @Transactional
    public void reduceStock(Long productId, int quantity) {
    int updated = inventoryRepository.reduceStock(productId, quantity);

    if (updated == 0) {
        throw new RuntimeException("Insufficient stock");
    }
}
}