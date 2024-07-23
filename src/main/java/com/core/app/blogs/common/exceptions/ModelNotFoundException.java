package com.core.app.blogs.common.exceptions;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message + " not found");
    }
}
