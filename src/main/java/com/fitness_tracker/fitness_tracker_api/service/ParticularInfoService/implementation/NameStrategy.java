package com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.implementation;

import com.fitness_tracker.fitness_tracker_api.entity.User;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Annotation.ParticularInfoAnnotation;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.IParticularInfoStrategy;

@ParticularInfoAnnotation(metric = "name")
public class NameStrategy implements IParticularInfoStrategy {
    @Override
    public String getParticularInfo(User user) {
        return user.getName();
    }
}
