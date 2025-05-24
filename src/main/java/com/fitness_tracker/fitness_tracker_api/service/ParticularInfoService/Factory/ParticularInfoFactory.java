package com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Factory;

import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Annotation.ParticularInfoAnnotation;
import com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.IParticularInfoStrategy;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParticularInfoFactory implements IParticularInfoFactory {
    private final String PACKAGE_PATH = "com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService";
    private final String RUNTIME_EXEPTION_MESSAGE = "Failed to instantiate strategy for metric: ";

    Map<String,IParticularInfoStrategy> strategies = new HashMap<>();

    public  ParticularInfoFactory(){
        Reflections reflections = new Reflections(PACKAGE_PATH);
        Set<Class<? extends IParticularInfoStrategy>> classes = reflections.getSubTypesOf(IParticularInfoStrategy.class);
        for(Class<? extends  IParticularInfoStrategy> tempClass : classes){
            ParticularInfoAnnotation info = tempClass.getAnnotation(ParticularInfoAnnotation.class);
            if(info != null){
                try {
                strategies.put(info.metric(),tempClass.getDeclaredConstructor().newInstance());
                }
                catch (Exception ex) {
                    throw new RuntimeException(RUNTIME_EXEPTION_MESSAGE + info.metric(),ex);
                }
            }
        }
    }

    @Override
    public IParticularInfoStrategy getParticularInfoStrategy(String metric) {
        return strategies.get(metric);
    }
}
