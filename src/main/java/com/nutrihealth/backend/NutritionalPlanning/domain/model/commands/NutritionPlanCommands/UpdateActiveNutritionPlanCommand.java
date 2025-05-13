package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

public record UpdateActiveNutritionPlanCommand(
        Long planId,
        boolean active
) {
}
