package com.orderflow.inventoryservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INVENTORY", indexes = {
    @Index(name = "idx_product_id", columnList = "PRODUCT_ID")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_ID", nullable = false, unique = true)
    private Long productId;

    @Column(name = "AVAILABLE_QUANTITY", nullable = false)
    private Integer availableQuantity;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}