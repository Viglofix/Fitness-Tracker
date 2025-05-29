package com.fitness_tracker.fitness_tracker_api.exception;

/**
 * Exception thrown when a requested user cannot be found.
 * Typically occurs when querying for a non-existent user ID or email.
 */
public class UserNotFoundException extends RuntimeException {
    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param msg the detail message explaining the exception
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }
}