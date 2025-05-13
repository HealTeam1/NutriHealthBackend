package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.update;

import java.util.List;
import java.util.Optional;

public record UpdateScheduledMealResource(
        Optional<Long> recipeId,
        List<UpdatePlannedFoodResource> plannedFoods
) {

}
