package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.ScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

import java.util.Optional;

public class ScheduledMealResourceFromEntityAssembler {
    public static ScheduledMealResource toResource(ScheduledMeal entity){
        return new ScheduledMealResource(
                entity.getId(),
                entity.getDailyPlan().getId(),
                entity.getTimeDay(),
                Optional.ofNullable(entity.getRecipeId()),
                entity.getPlannedFoods().stream().map(PlannedFoodResourceFromEntityAssembler::toResource).toList()
        );
    }
}
