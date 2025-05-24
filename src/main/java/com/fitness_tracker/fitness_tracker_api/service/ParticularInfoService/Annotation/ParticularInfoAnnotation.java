package com.fitness_tracker.fitness_tracker_api.service.ParticularInfoService.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ParticularInfoAnnotation {
    String metric();
}
