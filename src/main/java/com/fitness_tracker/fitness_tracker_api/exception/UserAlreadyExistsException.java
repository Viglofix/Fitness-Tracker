package com.fitness_tracker.fitness_tracker_api.exception;

/**
 * Exception thrown when attempting to create a user that already exists.
 * Typically occurs when trying to register with an email that's already in use.
 */
public class UserAlreadyExistsException extends RuntimeException {
    /**
     * Constructs a new UserAlreadyExistsException with the specified detail message.
     *
     * @param msg the detail message explaining the exception
     */
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}