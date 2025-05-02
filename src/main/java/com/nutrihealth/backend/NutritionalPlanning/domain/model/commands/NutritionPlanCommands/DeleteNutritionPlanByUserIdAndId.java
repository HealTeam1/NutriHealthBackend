package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

public record DeleteNutritionPlanByUserIdAndId(
        Long userId,
        Long planId

) {
}
