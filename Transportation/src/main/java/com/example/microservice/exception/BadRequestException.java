package com.example.microservice.exception;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 4439108742868444642L;

    public BadRequestException() {
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String msg) {
        super(msg);
    }

}
