package com.fitness_tracker.fitness_tracker_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for basic user information.
 * Contains minimal user details for summary views.
 *
 * @param Id   the unique identifier of the user
 * @param Name the full name of the user
 */
public record BasicInfoDto (
        Long Id,
        String Name) {}