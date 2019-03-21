package com.exadel.mooc.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public EntityNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EntityNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
