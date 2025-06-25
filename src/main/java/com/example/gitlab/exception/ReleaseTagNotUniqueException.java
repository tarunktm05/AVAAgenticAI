package com.example.gitlab.exception;

public class ReleaseTagNotUniqueException extends RuntimeException {
    public ReleaseTagNotUniqueException(String message) {
        super(message);
    }
}