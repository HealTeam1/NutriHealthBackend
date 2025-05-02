package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands;

public record DeleteDailyPlanCommand(
        Long userId,
        Long planId,
        Long dailyPlanId
) {
}
