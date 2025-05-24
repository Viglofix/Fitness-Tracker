package com.fitness_tracker.fitness_tracker_api.dto;

import java.time.LocalDate;

public record UserDto (
        Long id,
        String name,
        String lastName,
        LocalDate birthDate,
        String email,
        Integer age
     ) {}
