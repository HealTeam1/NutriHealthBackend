package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;

public record UpdatePlannedFoodCommand(
        Long foodId,
        Integer amount,
        Unit unit
) {
}
