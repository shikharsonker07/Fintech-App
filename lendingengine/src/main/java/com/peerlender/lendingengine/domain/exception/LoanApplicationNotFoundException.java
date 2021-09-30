package com.peerlender.lendingengine.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException {

    public LoanApplicationNotFoundException(long id) {
        super("loan application with ID " + id + " not found!");
    }

}
