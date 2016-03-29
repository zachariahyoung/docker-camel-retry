package com.zandroid.dockercamelretry;

public class LowerCaseException extends RuntimeException {

    public LowerCaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LowerCaseException() {
    }
}