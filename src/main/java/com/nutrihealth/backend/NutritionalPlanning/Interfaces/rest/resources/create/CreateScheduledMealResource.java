package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;

import java.util.List;

public record CreateScheduledMealResource(
        TimeDay timeDay,
        Long recipeId,
        List<CreatePlannedFoodResource> plannedFoods
) {
}
