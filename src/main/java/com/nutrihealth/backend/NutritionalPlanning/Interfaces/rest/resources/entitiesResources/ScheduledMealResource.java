package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;

import java.util.List;
import java.util.Optional;

public record ScheduledMealResource(
        Long id,
        Long dailyPlanId,
        TimeDay timeDay,
        Optional<Long> recipeId,
        List<PlannedFoodResource> plannedFoods
) {
}
