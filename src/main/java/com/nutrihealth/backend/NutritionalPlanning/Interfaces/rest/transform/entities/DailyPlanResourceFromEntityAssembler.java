package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;

public class DailyPlanResourceFromEntityAssembler {
    public static DailyPlanResource toResource(DailyPlan entity){
        return new DailyPlanResource(
                entity.getId(),
                entity.getNutritionalPlan().getId(),
                entity.getWeekDay(),
                entity.getScheduledMeals().stream().map(ScheduledMealResourceFromEntityAssembler::toResource).toList()
        );
    }
}
