package com.fitness_tracker.fitness_tracker_api.mapper;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;

/**
 * Mapper class for converting between User entities and BasicInfoDto objects.
 * Provides static methods for mapping operations.
 */
public class BasicInfoMapper {
    /**
     * Converts a User entity to a BasicInfoDto.
     *
     * @param user the User entity to convert
     * @return BasicInfoDto containing the user's ID and name
     * @throws IllegalArgumentException if the user parameter is null
     */
    public static BasicInfoDto mapToBasicInfoDto(User user) {
        return new BasicInfoDto(
                user.getId(),
                user.getName()
        );
    }
}