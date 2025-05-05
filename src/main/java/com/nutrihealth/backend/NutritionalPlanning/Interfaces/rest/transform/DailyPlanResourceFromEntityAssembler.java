package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import jakarta.persistence.Entity;

public class DailyPlanResourceFromEntityAssembler {
    public static DailyPlanResource toResourceFromEntity(DailyPlan entity){
        return new DailyPlanResource(
                entity.getId(),
                entity.getNutritionalPlan().getId(),
                entity.getWeekDay(),
                entity.getScheduledMeals().stream()
                        .map(ScheduledMealResourceFromEntityAssembler::toResourceFromEntity)
                        .toList()
        );
    }
}
