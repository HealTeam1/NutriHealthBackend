package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

import java.util.Date;

public record UpdateNutritionalPlanCommand(
        Long userId,
        Long planId,
        String name,
        Date startDate,
        String description,
        boolean active
) {
}
