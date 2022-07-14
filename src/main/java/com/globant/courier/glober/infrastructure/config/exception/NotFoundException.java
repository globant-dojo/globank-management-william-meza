package com.globant.courier.glober.infrastructure.config.exception;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
