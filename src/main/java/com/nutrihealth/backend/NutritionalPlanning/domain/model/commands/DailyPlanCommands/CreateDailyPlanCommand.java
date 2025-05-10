package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record CreateDailyPlanCommand(
        WeekDay weekDay,
        List<CreateScheduledMealCommand> scheduledMeals
) {
}
