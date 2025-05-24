package com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.implementation;

import com.fitness_tracker.fitness_tracker_api.entity.User;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Annotation.ParticularInfoAnnotation;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.IParticularInfoStrategy;

@ParticularInfoAnnotation(metric="id")
public class IdStrategy implements IParticularInfoStrategy {
    @Override
    public String getParticularInfo(User user) {
        return user.getId().toString();
    }
}
