package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

public class CreateScheduledMealCommandFromResourceAssembler {
    public static CreateScheduledMealCommand toCommand(CreateScheduledMealResource resource) {
        return new CreateScheduledMealCommand(
                resource.recipeId(),
                resource.timeDay(),
                resource.plannedFoodResources().stream()
                        .map(CreatePlannedFoodCommandFromResourceAssembler::toCommand)
                        .toList()
        );
    }
}
