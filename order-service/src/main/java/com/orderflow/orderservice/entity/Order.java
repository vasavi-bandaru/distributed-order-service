package com.orderflow.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.orderflow.orderservice.enums.PaymentStatus;

import com.orderflow.orderservice.enums.OrderStatus;

@Entity
@Table(name = "ORDERS", indexes = {
        @Index(name = "idx_order_number", columnList = "ORDER_NUMBER"),
        @Index(name = "idx_user_id", columnList = "USER_ID"),
        @Index(name = "idx_user_status", columnList = "USER_ID, STATUS")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_NUMBER", nullable = false, unique = true)
    private String orderNumber;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "QUANTITY",nullable = false)
    private Integer quantity;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_STATUS", nullable = false)
    private PaymentStatus paymentStatus;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}