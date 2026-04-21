package com.orderflow.orderservice.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String transactionId;
    private String code;
    private String message;
    private LocalDateTime timestamp;
    private List<ErrorResponseField> errors;
}