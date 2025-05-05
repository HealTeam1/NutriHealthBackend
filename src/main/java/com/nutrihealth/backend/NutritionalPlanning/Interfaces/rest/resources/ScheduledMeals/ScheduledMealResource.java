package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.PlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;

import java.util.List;

public record ScheduledMealResource(
        Long recipeId,
        TimeDay timeDay,
        List<PlannedFoodResource> plannedFoods
) {
}
