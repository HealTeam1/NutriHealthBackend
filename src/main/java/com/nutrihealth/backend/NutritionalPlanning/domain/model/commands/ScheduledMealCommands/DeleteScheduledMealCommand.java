package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public record DeleteScheduledMealCommand(
        Long userId,
        Long planId,
        WeekDay weekDay,
        TimeDay timeDay
) {
}
