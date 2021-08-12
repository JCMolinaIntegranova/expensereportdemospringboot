package com.integranova.spring.expensereportdemo.exception;

public class PreconditionException extends ModelException {

    /**
     * Serialization UID.
     */
    private static final long serialVersionUID = 1L;

    public PreconditionException(String message) {
        super(ErrorInfo.PRECONDITION, message);
    }

}
