package com.fitness_tracker.fitness_tracker_api.mapper;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;

/**
 * Mapper class for converting between User entities and UserDto objects.
 * Provides bidirectional mapping capabilities.
 */
public class UserMapper {
    /**
     * Converts a User entity to a UserDto.
     *
     * @param user the User entity to convert
     * @return UserDto containing all user properties
     * @throws IllegalArgumentException if the user parameter is null
     */
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getAge()
        );
    }

    /**
     * Converts a UserDto to a User entity.
     *
     * @param userDto the UserDto to convert
     * @return User entity containing all properties from the DTO
     * @throws IllegalArgumentException if the userDto parameter is null
     */
    public static User maptoUser(UserDto userDto) {
        return new User(
                userDto.id(),
                userDto.name(),
                userDto.lastName(),
                userDto.birthDate(),
                userDto.email(),
                userDto.age()
        );
    }
}
