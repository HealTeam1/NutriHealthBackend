package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.ScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

public class ScheduledMealResourceFromEntityAssembler {
    public static ScheduledMealResource toResourceFromEntity(ScheduledMeal entity){
        return new ScheduledMealResource(
                entity.getId(),
                entity.getTimeDay(),
                entity.getPlannedFoods().stream().map(PlannedFoodResourceFromEntityAssembler::toResourceFromEntity).toList()
        );

    }
}
