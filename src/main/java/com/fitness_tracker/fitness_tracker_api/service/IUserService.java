package com.fitness_tracker.fitness_tracker_api.service;

import com.fitness_tracker.fitness_tracker_api.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    void deleteUser(Long id);
    List<UserDto> getAllUsers();
    String getParticularInfo(Long id, String infoType);
    UserDto updateUser(UserDto userDto);
}
