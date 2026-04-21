package com.orderflow.inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderflow.inventoryservice.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProductId(Long productId);

    @Modifying
    @Query("UPDATE Inventory inv SET inv.availableQuantity = inv.availableQuantity - :quantity WHERE inv.productId = :productId AND inv.availableQuantity >= :quantity")
    int reduceStock(@Param("productId") Long productId, @Param("quantity") int quantity);
}