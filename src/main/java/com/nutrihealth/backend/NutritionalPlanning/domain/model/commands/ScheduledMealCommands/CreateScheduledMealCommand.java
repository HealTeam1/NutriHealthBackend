package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;

import java.util.List;

public record CreateScheduledMealCommand(
        Long recipeId,
        TimeDay timeDay,
        List<CreatePlannedFoodCommand> plannedFoods
) {
}
