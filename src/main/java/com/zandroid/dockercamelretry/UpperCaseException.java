package com.zandroid.dockercamelretry;

public class UpperCaseException extends RuntimeException {

    public UpperCaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpperCaseException() {
    }
}