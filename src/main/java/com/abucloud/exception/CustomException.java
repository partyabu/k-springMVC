package com.abucloud.exception;

/**
 * @author party-abu
 */
public class CustomException extends RuntimeException {

    private String message;

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public CustomException() {
    }

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}