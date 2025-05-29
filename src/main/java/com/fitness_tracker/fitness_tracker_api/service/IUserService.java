package com.fitness_tracker.fitness_tracker_api.service;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoEmailDto;
import com.fitness_tracker.fitness_tracker_api.dto.UserDto;

import java.util.List;

/**
 * Service interface defining operations for user management.
 * Contains methods for CRUD operations and specialized user queries.
 */
public interface IUserService {
    /**
     * Creates a new user.
     *
     * @param userDto the user data to create
     * @return the created user DTO
     * @throws com.fitness_tracker.fitness_tracker_api.exception.UserAlreadyExistsException if user with same email exists
     */
    UserDto createUser(UserDto userDto);

    /**
     * Retrieves a user by ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user DTO
     * @throws com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException if user not found
     */
    UserDto getUserById(Long id);

    /**
     * Deletes a user by ID.
     *
     * @param id the ID of the user to delete
     * @throws com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException if user not found
     */
    void deleteUser(Long id);

    /**
     * Retrieves all users.
     *
     * @return list of all user DTOs
     */
    List<UserDto> getAllUsers();

    /**
     * Retrieves specific information about a user.
     *
     * @param id the ID of the user
     * @param infoType the type of information to retrieve (e.g., "email")
     * @return the requested information as string
     * @throws com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException if user not found
     * @throws IllegalArgumentException if infoType is not supported
     */
    String getParticularInfo(Long id, String infoType);

    /**
     * Updates an existing user.
     *
     * @param id the ID of the user to update
     * @param userDto the updated user data
     * @return the updated user DTO
     * @throws com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException if user not found
     */
    UserDto updateUser(Long id, UserDto userDto);

    /**
     * Retrieves basic information about all users.
     *
     * @return list of basic user information DTOs
     */
    List<BasicInfoDto> getBasicInfo();

    /**
     * Retrieves basic information about a user by email.
     *
     * @param email the email to search for
     * @return basic user information with email DTO
     * @throws com.fitness_tracker.fitness_tracker_api.exception.UserNotFoundException if user not found
     */
    BasicInfoEmailDto getBasicInfoEmail(String email);

    /**
     * Retrieves all users older than specified age.
     *
     * @param Age the minimum age threshold
     * @return list of user DTOs older than specified age
     */
    List<UserDto> getUsersByAge(Integer Age);
}
