package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public record UpdateDailyPlanCommand(
        Long userId,
        Long planId,
        Long dailyPlanId,
        WeekDay weekDay
) {
}
