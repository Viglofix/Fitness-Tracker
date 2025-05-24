package com.fitness_tracker.fitness_tracker_api.mapper;

import com.fitness_tracker.fitness_tracker_api.dto.BasicInfoDto;
import com.fitness_tracker.fitness_tracker_api.entity.User;

public class BasicInfoMapper {
    public static BasicInfoDto mapToBasicInfoDto(User user){
        return new BasicInfoDto(
                user.getId(),
                user.getName()
        );
    }
}
