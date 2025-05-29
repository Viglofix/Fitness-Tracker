package com.fitness_tracker.fitness_tracker_api.dto;

/**
 * Data Transfer Object containing basic user information with email.
 * Used for operations requiring email address along with user identifier.
 *
 * @param id    the unique identifier of the user
 * @param email the email address of the user
 */
public record BasicInfoEmailDto(
        Long id,
        String email
) {}