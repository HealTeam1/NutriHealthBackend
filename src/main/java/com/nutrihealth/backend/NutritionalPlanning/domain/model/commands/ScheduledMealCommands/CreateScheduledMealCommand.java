package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;

public record CreateScheduledMealCommand(
        Long userId,
        Long planId,
        Long dailyPlanId,
        Long recipeId,
        TimeDay timeDay
) {
}
