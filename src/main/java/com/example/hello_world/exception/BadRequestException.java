package com.example.hello_world.exception;

public class BadRequestException extends RuntimeException {

    private String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
