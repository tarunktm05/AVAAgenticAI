package com.example.gitlab.exception;

public class ReleaseAlreadyAssociatedException extends RuntimeException {
    public ReleaseAlreadyAssociatedException(String message) {
        super(message);
    }
}