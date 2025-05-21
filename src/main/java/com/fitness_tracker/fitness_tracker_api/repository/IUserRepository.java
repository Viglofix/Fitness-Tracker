package com.fitness_tracker.fitness_tracker_api.repository;

import com.fitness_tracker.fitness_tracker_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
