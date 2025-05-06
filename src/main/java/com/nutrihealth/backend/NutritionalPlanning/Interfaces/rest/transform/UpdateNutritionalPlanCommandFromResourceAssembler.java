package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan.UpdateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;

public class UpdateNutritionalPlanCommandFromResourceAssembler {
    public static UpdateNutritionalPlanCommand toCommandFromResource(UpdateNutritionalPlanResource resource, Long userId, Long planId) {
        return new UpdateNutritionalPlanCommand(
                userId,
                planId,
                resource.name(),
                resource.startDate(),
                resource.description(),
                resource.active()
        );

    }
}
