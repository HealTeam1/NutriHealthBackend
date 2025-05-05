package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record CreateScheduledMealCommand(
        Long userId,
        Long planId,
        WeekDay weekDay,
        Long recipeId,
        TimeDay timeDay,
        List<PlannedFood> plannedFoods
) {
}
