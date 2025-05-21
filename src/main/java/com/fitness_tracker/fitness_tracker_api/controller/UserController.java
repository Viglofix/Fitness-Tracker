package com.fitness_tracker.fitness_tracker_api.controller;

import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;
import com.fitness_tracker.fitness_tracker_api.mapper.UserMapper;
import com.fitness_tracker.fitness_tracker_api.service.implementation.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedDto = userService.createUser(userDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto savedDto  = userService.getUserById(id);
        return new ResponseEntity<>(savedDto,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> savedDtos = userService.getAllUsers();
        return  ResponseEntity.ok(savedDtos);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User has been successfully deleted ${id}");
    }
    @GetMapping("/getInfo")
    public ResponseEntity<String> getInfo(@RequestParam Long id, @RequestParam String infoType){
        String particularInfo = userService.getParticularInfo(id,infoType);
        return ResponseEntity.ok(particularInfo);
    }
}
