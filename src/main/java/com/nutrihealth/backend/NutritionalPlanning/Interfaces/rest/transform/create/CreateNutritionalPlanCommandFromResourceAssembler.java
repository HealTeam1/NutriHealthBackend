package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;

public class CreateNutritionalPlanCommandFromResourceAssembler {
    public static CreateNutritionalPlanCommand toCommand(CreateNutritionalPlanResource resource) {
        return new CreateNutritionalPlanCommand(
                resource.userId(),
                resource.startDate(),
                resource.name(),
                resource.description(),
                resource.active(),
                resource.dailyPlans().stream()
                        .map(CreateDailyPlanCommandFromResourceAssembler::toCommand)
                        .toList()
        );
    }
}
