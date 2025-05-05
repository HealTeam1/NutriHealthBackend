package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;

public class CreateScheduledMealCommandFromCreateScheduledMealResourceAssembler {
    public static CreateScheduledMealCommand toCommandFromResource(CreateScheduledMealResource resource) {
        return new CreateScheduledMealCommand(
                resource.userId(),
                resource.planId(),
                resource.weekDay(),
                resource.recipeId(),
                resource.timeDay(),
                resource.plannedFoods().stream().map(PlannedFoodFromCreatePlannedFoodResourceAssembler::toEntityFromResource).toList()
        );
    }
}
