package com.fitness_tracker.fitness_tracker_api.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Represents an API error response.
 * Contains details about errors that occur during API operations.
 */
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    /** The error code representing the type of error */
    private Integer errorCode;

    /** The description of the error */
    private String errorDesc;

    /** The timestamp when the error occurred */
    private Date date;
}
