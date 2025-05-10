package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;

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
