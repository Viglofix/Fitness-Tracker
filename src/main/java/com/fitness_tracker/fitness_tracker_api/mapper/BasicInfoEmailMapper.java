package com.fitness_tracker.fitness_tracker_api.mapper;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoEmailDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;

public class BasicInfoEmailMapper {
    public static BasicInfoEmailDto mapToBasicInfoEmail(User user) {
        return new BasicInfoEmailDto(
                user.getId(),
                user.getEmail()
        );
    }
}
