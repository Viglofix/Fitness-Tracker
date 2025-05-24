package com.fitness_tracker.fitness_tracker_api.service.implementation;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoEmailDto;
import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;
import com.fitness_tracker.fitness_tracker_api.exception.UserAlreadyExistsException;
import com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException;
import com.fitness_tracker.fitness_tracker_api.mapper.BasicInfoEmailMapper;
import com.fitness_tracker.fitness_tracker_api.mapper.BasicInfoMapper;
import com.fitness_tracker.fitness_tracker_api.mapper.UserMapper;
import com.fitness_tracker.fitness_tracker_api.repository.IUserRepository;
import com.fitness_tracker.fitness_tracker_api.service.IUserService;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Factory.IParticularInfoFactory;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Factory.ParticularInfoFactory;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.IParticularInfoStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService implements IUserService  {
    private final String USER_EXCEPTION_EMAIL_EXISTS = "User with the given email already exists";
    private final String USER_EXCEPTION_EMAIL_NOTFOUND = "Email not found in the list of users";
    @Autowired
    private IUserRepository repository;

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userDto.id() == null) {
            Optional<User> email = repository.findAll().stream().filter(usr->usr.getEmail().equalsIgnoreCase(userDto.email()))
                    .findFirst();
            User user = email.orElse(new User());

            if(user.getId() != null) {
                throw new UserAlreadyExistsException(USER_EXCEPTION_EMAIL_EXISTS);
            }

            User userToSave = UserMapper.maptoUser(userDto);
            repository.save(userToSave);
            return UserMapper.mapToUserDto(userToSave);
        }
        return null;
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

        IParticularInfoFactory particularInfoFactory = new ParticularInfoFactory();
        IParticularInfoStrategy instanceOfParticularStrategy = particularInfoFactory.getParticularInfoStrategy(infoType);
        return instanceOfParticularStrategy.getParticularInfo(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = repository.findById(id).orElseThrow();

        user.setName(userDto.name());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setBirthDate(userDto.birthDate());
        user.setAge(user.getAge());

        repository.save(user);

        return  UserMapper.mapToUserDto(user);
    }

    @Override
    public List<BasicInfoDto> getBasicInfo() {
        var users = repository.findAll();
        return users.stream().map((usr)->BasicInfoMapper.mapToBasicInfoDto(usr)).collect(Collectors.toList());
    }

    @Override
    public BasicInfoEmailDto getBasicInfoEmail(String email) {
        String atSignIndex = "@";
        Integer startIndex = 0;

        var users = repository.findAll();
        for(var x : users) {
            String emailNameElementInList = x.getEmail().substring(startIndex,x.getEmail().indexOf(atSignIndex));
            if(x.getEmail().equalsIgnoreCase(email) || emailNameElementInList.equalsIgnoreCase(email)) {
                BasicInfoEmailDto basicInfoEmailDto = BasicInfoEmailMapper.mapToBasicInfoEmail(x);
                return basicInfoEmailDto;
            }
        }
        throw new UserNotFoundException(USER_EXCEPTION_EMAIL_NOTFOUND);
    }

    @Override
    public List<UserDto> getUsersByAge(Integer Age) {
       var users = repository.findAll().stream().filter(x->x.getAge()>Age)
               .collect(Collectors.toList());
       return users.stream().map((usr)->UserMapper.mapToUserDto(usr)).collect(Collectors.toList());
    }


}
