package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.CreateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;

public class CreateNutritionalPlanCommandFromResourceAssembler {
    public static CreateNutritionalPlanCommand toCommand(CreateNutritionalPlanResource resource, Long userId) {
        return new CreateNutritionalPlanCommand(
                userId,
                resource.startDate(),
                resource.name(),
                resource.description(),
                resource.active(),
                resource.dailyplans().stream()
                        .map(CreateDailyPlanCommandFromResourceAssembler::toCommand)
                        .toList()
        );
    }
}
