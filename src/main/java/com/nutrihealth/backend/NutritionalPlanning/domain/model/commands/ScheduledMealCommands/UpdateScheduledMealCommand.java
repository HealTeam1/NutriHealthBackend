package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.UpdatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;

import java.util.List;

public record UpdateScheduledMealCommand(
        TimeDay timeDay,
        Long recipeFood,
        List<UpdatePlannedFoodCommand> plannedFoods
) {
}
