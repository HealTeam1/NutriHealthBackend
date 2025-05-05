package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

public class ScheduledMealFromCreateScheduledMealResourceAssembler {
    public static ScheduledMeal toEntityFromResource(CreateScheduledMealResource scheduledMeal) {
        return new ScheduledMeal(CreateScheduledMealCommandFromCreateScheduledMealResourceAssembler.toCommandFromResource(scheduledMeal));
    }
}
