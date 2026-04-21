package com.orderflow.orderservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @Positive
    private Long productId;

    @NotNull
    @Min(1)
    private Integer quantity;
    
    @NotNull
    @Positive
    private BigDecimal totalPrice;

}