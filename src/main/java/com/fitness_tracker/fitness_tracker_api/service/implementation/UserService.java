package com.fitness_tracker.fitness_tracker_api.service.implementation;

import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;
import com.fitness_tracker.fitness_tracker_api.mapper.UserMapper;
import com.fitness_tracker.fitness_tracker_api.repository.IUserRepository;
import com.fitness_tracker.fitness_tracker_api.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService implements IUserService {
    private IUserRepository repository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.maptoUser(userDto);
        User savedUser = repository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = repository.findById(id).orElseThrow();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = repository.findById(id).orElseThrow();
        repository.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        var users = repository.findAll();
        return users.stream().map((usr)-> UserMapper.mapToUserDto(usr)).collect(Collectors.toList());
    }
    @Override
    public String getParticularInfo(Long id, String infoType){
        var user = repository.findById(id).orElseThrow();
        switch (infoType){
            case "email":
                return  user.getName();
        }
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }
}
