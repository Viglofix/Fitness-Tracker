package com.fitness_tracker.fitness_tracker_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity class representing a user in the system.
 * Maps to the 'users' table in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    /** Unique identifier for the user */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "users_seq")
    private Long id;

    /** First name of the user */
    @Column(name="name")
    private String name;

    /** Last name of the user */
    @Column(name="last_name")
    private String lastName;

    /** Birth date of the user */
    @Column(name="birth_date")
    private LocalDate birthDate;

    /** Email address of the user (must be unique) */
    @Column(name="email", unique = true)
    private String email;

    /** Age of the user */
    @Column(name="age")
    private Integer age;
}