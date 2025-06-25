package com.example.gitlab.exception;

public class InvalidDateRangeException extends RuntimeException {
    public InvalidDateRangeException(String message) {
        super(message);
    }
}