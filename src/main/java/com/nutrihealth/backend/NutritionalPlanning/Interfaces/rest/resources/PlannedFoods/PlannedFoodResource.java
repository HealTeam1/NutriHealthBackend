package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;

public record PlannedFoodResource(
        Long id,
        Long foodId,
        Integer amount,
        Unit unit


) {
}
