package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record UpdateDailyPlanCommand(
        Long userId,
        Long planId,
        Long dailyPlanId,
        WeekDay weekDay,
        List<ScheduledMeal> scheduledMeals
) {
}
