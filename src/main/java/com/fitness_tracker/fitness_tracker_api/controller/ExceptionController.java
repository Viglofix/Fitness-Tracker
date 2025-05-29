package com.fitness_tracker.fitness_tracker_api.controller;

import com.fitness_tracker.fitness_tracker_api.exception.UserAlreadyExistsException;
import com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Global exception handler for user-related exceptions.
 * Provides centralized exception handling across all user controllers.
 */
@AllArgsConstructor
@RestControllerAdvice
@RequestMapping("/api/users")
public class ExceptionController {

    /**
     * Handles UserAlreadyExistsException when a duplicate user is detected.
     *
     * @param ex the caught UserAlreadyExistsException
     * @return ResponseEntity containing the error message and HTTP status code 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles UserNotFoundException when a requested user is not found.
     *
     * @param ex the caught UserNotFoundException
     * @return ResponseEntity containing the error message and HTTP status code 404
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}