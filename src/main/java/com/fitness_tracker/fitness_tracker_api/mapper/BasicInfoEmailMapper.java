package com.fitness_tracker.fitness_tracker_api.mapper;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoEmailDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;

/**
 * Mapper class for converting between User entities and BasicInfoEmailDto objects.
 * Specifically handles mapping of user email information.
 */
public class BasicInfoEmailMapper {
    /**
     * Converts a User entity to a BasicInfoEmailDto.
     *
     * @param user the User entity to convert
     * @return BasicInfoEmailDto containing the user's ID and email
     * @throws IllegalArgumentException if the user parameter is null
     */
    public static BasicInfoEmailDto mapToBasicInfoEmail(User user) {
        return new BasicInfoEmailDto(
                user.getId(),
                user.getEmail()
        );
    }
}