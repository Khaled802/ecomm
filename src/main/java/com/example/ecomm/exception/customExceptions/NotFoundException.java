package com.example.ecomm.exception.customExceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Not found");
    }

    public NotFoundException(String entityName) {
        super("Not found " + entityName);
    }
}
