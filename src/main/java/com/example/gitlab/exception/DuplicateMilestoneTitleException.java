package com.example.gitlab.exception;

public class DuplicateMilestoneTitleException extends RuntimeException {
    public DuplicateMilestoneTitleException(String message) {
        super(message);
    }
}