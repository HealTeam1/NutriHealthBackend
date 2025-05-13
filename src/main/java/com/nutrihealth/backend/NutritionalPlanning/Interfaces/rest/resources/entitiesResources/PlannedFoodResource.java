package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;

public record PlannedFoodResource(
        Long foodId,
        Integer amount,
        Unit unit
) {
}
