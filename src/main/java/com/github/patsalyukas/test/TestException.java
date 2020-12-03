package com.github.patsalyukas.test;

public class TestException extends ATMException {

    public TestException() {
    }

    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestException(Throwable cause) {
        super(cause);
    }

    public TestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
