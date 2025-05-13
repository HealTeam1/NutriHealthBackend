package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.update;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;

public record UpdatePlannedFoodResource(
        Long foodId,
        Integer amount,
        Unit unit
) {

}
