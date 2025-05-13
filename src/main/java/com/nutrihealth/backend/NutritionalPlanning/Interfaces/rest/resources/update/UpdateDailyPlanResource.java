package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.update;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record UpdateDailyPlanResource(
        WeekDay weekDay,
        List<UpdateScheduledMealCommand> scheduledMeals
) {
}
