package com.peerlender.lendingengine.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long userID) {
        super("User with ID " + userID + " not found!");
    }

}
