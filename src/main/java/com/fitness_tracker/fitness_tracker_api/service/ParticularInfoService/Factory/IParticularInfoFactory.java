package com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Factory;

import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.IParticularInfoStrategy;

public interface IParticularInfoFactory {
    IParticularInfoStrategy getParticularInfoStrategy(String metric);
}
