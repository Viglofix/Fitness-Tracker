package com.fitness_tracker.fitness_tracker_api.mapper;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;

public class UserMapper
{
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getAge()
        );
    }
    public static User maptoUser(UserDto userDto){
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
