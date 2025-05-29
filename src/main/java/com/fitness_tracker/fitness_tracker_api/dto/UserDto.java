package com.fitness_tracker.fitness_tracker_api.dto;

import java.time.LocalDate;

/**
 * Complete Data Transfer Object representing a user.
 * Contains all user details for creation, retrieval, and update operations.
 *
 * @param id        the unique identifier of the user
 * @param name      the first name of the user
 * @param lastName  the last name of the user
 * @param birthDate the birth date of the user
 * @param email     the email address of the user (must be unique)
 * @param age       the age of the user
 */
public record UserDto (
        Long id,
        String name,
        String lastName,
        LocalDate birthDate,
        String email,
        Integer age
) {}
