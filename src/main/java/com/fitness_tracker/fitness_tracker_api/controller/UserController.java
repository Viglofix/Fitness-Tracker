package com.fitness_tracker.fitness_tracker_api.controller;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoEmailDto;
import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import com.fitness_tracker.fitness_tracker_api.service.implementation.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final String DELETE_RESPONSE_MESSAGE = "User has been successfully deleted ${id}";
    private final String PUT_RESPONSE_MESSAGE = "User has been successfully updated ${id}";

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedDto = userService.createUser(userDto);
        if(userDto != null) {
            return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(savedDto,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto savedDto  = userService.getUserById(id);
        return new ResponseEntity<>(savedDto,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> savedDtos = userService.getAllUsers();
        return  ResponseEntity.ok(savedDtos);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(DELETE_RESPONSE_MESSAGE);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
        return ResponseEntity.ok(PUT_RESPONSE_MESSAGE);
    }
    @GetMapping("/get-info")
    public ResponseEntity<String> getInfo(@RequestParam Long id, @RequestParam String infoType){
        String particularInfo = userService.getParticularInfo(id,infoType);
        return ResponseEntity.ok(particularInfo);
    }
    @GetMapping("/basic-info")
    public ResponseEntity<List<BasicInfoDto>> getAllBasicInfo() {
        var users = userService.getBasicInfo();
        return  ResponseEntity.ok(users);
    }
    @GetMapping("/basic-info-email/{email}")
    public ResponseEntity<BasicInfoEmailDto> getBasicInfoEmail(@PathVariable("email") String email) {
        var users = userService.getBasicInfoEmail(email);
        return  ResponseEntity.ok(users);
    }
    @GetMapping("/all_users_by_age/{age}")
    public ResponseEntity<List<UserDto>> getAllUsersByAge(@PathVariable("age") Integer age) {
        var users = userService.getUsersByAge(age);
        return ResponseEntity.ok(users);
    }
}
