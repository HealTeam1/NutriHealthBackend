package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public record DeleteDailyPlanCommand(
        Long userId,
        Long planId,
        WeekDay weekDay
) {
}
