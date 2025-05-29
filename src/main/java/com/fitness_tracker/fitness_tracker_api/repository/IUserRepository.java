package com.fitness_tracker.fitness_tracker_api.repository;

import com.fitness_tracker.fitness_tracker_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User entity CRUD operations.
 * Extends JpaRepository to provide standard data access methods.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}