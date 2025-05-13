package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.update;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;

public record UpdatePlannedFoodResource(
        Integer amount,
        Unit unit
) {

}
