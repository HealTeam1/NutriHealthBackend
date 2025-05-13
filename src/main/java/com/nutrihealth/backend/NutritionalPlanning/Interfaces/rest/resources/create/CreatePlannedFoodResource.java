package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;

public record CreatePlannedFoodResource(
        Long foodId,
        Integer amount,
        Unit unit
) {
}
