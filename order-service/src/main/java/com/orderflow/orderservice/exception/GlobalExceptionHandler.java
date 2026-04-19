package com.orderflow.orderservice.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex) {

        List<ErrorResponseField> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> errors.add(new ErrorResponseField(
                error.getField(),
                error.getDefaultMessage())));

        ErrorResponse response = new ErrorResponse(
                UUID.randomUUID().toString(), // transactionId
                "VALIDATION_ERROR", // code
                "Validation failed",
                LocalDateTime.now(),
                errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
