package com.fitness_tracker.fitness_tracker_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public record BasicInfoDto (
    Long Id,
    String Name){}
