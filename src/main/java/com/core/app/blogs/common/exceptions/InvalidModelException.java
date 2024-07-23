package com.core.app.blogs.common.exceptions;

public class InvalidModelException extends RuntimeException {
    public InvalidModelException(String message) {
        super("Invalid " + message);
    }
}
