package com.example.crm.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException ex, HttpServletRequest request) {
        log.warn("Customer not found: {}", ex.getMessage());
        ErrorResponse error = ErrorResponse.builder()
                .error("Customer not found")
                .message(ex.getMessage())
                .traceId(request.getHeader("X-B3-TraceId"))
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmail(DuplicateEmailException ex, HttpServletRequest request) {
        log.warn("Duplicate email: {}", ex.getMessage());
        ErrorResponse error = ErrorResponse.builder()
                .error("Duplicate email")
                .message(ex.getMessage())
                .traceId(request.getHeader("X-B3-TraceId"))
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ValidationException ex, HttpServletRequest request) {
        log.warn("Validation failed: {}", ex.getMessage());
        ErrorResponse error = ErrorResponse.builder()
                .error("Validation failed")
                .message(ex.getMessage())
                .traceId(request.getHeader("X-B3-TraceId"))
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");
        log.warn("Validation failed: {}", message);
        ErrorResponse error = ErrorResponse.builder()
                .error("Validation failed")
                .message(message)
                .traceId(request.getHeader("X-B3-TraceId"))
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest request) {
        log.error("Internal error: {}", ex.getMessage(), ex);
        ErrorResponse error = ErrorResponse.builder()
                .error("Internal server error")
                .message("An unexpected error occurred")
                .traceId(request.getHeader("X-B3-TraceId"))
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
