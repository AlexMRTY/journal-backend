package com.asifshirvan.journal_backend.exceptions;

public class JpaException extends RuntimeException {
    public JpaException(String message) {
        super(message);
    }
}
