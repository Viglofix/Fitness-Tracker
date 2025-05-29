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

/**
 * Controller for handling user-related operations.
 * Provides endpoints for creating, retrieving, updating, and deleting users,
 * as well as specialized user information retrieval.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final String DELETE_RESPONSE_MESSAGE = "User has been successfully deleted ";
    private final String PUT_RESPONSE_MESSAGE = "User has been successfully updated ";

    @Autowired
    private UserService userService;

    /**
     * Creates a new user.
     *
     * @param userDto the user data to create
     * @return ResponseEntity containing the created user and HTTP status
     */
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedDto = userService.createUser(userDto);
        if(userDto != null) {
            return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(savedDto,HttpStatus.BAD_REQUEST);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return ResponseEntity containing the user and HTTP status
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto savedDto  = userService.getUserById(id);
        return new ResponseEntity<>(savedDto,HttpStatus.OK);
    }

    /**
     * Retrieves all users.
     *
     * @return ResponseEntity containing a list of all users and HTTP status
     */
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> savedDtos = userService.getAllUsers();
        return  ResponseEntity.ok(savedDtos);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete
     * @return ResponseEntity with confirmation message and HTTP status
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(DELETE_RESPONSE_MESSAGE+id.toString());
    }

    /**
     * Updates an existing user.
     *
     * @param id the ID of the user to update
     * @param userDto the updated user data
     * @return ResponseEntity with confirmation message and HTTP status
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
        return ResponseEntity.ok(PUT_RESPONSE_MESSAGE+id.toString());
    }

    /**
     * Retrieves specific information about a user.
     *
     * @param id the ID of the user
     * @param infoType the type of information to retrieve (e.g., "email")
     * @return ResponseEntity containing the requested information
     */
    @GetMapping("/get-info")
    public ResponseEntity<String> getInfo(@RequestParam Long id, @RequestParam String infoType){
        String particularInfo = userService.getParticularInfo(id,infoType);
        return ResponseEntity.ok(particularInfo);
    }

    /**
     * Retrieves basic information about all users.
     *
     * @return ResponseEntity containing a list of basic user information
     */
    @GetMapping("/basic-info")
    public ResponseEntity<List<BasicInfoDto>> getAllBasicInfo() {
        var users = userService.getBasicInfo();
        return  ResponseEntity.ok(users);
    }

    /**
     * Retrieves basic information about a user by email or email prefix.
     *
     * @param email the email or email prefix to search for
     * @return ResponseEntity containing the basic user information
     */
    @GetMapping("/basic-info-email/{email}")
    public ResponseEntity<BasicInfoEmailDto> getBasicInfoEmail(@PathVariable("email") String email) {
        var users = userService.getBasicInfoEmail(email);
        return  ResponseEntity.ok(users);
    }

    /**
     * Retrieves all users older than a specified age.
     *
     * @param age the minimum age threshold
     * @return ResponseEntity containing a list of users older than the specified age
     */
    @GetMapping("/all_users_by_age/{age}")
    public ResponseEntity<List<UserDto>> getAllUsersByAge(@PathVariable("age") Integer age) {
        var users = userService.getUsersByAge(age);
        return ResponseEntity.ok(users);
    }
}