package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan.CreateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;

import java.util.Optional;

public class CreateNutritionalPlanCommandFromResourceAssembler {
    public static CreateNutritionalPlanCommand toCommandFromResource(CreateNutritionalPlanResource resource, Long userId){
        return new CreateNutritionalPlanCommand(
                userId,
                resource.startDate(),
                resource.name(),
                Optional.ofNullable(resource.description()),
                resource.active()
        );
    }
}
