package com.example.mcspartner.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4439108742868444642L;

    public NotFoundException() {
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String msg) {
        super(msg);
    }

}
