package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.update;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.update.UpdatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.UpdatePlannedFoodCommand;

public class UpdatePlannedFoodCommandFromResourceAssembler {
    public static UpdatePlannedFoodCommand toCommand(UpdatePlannedFoodResource resource) {
        return new UpdatePlannedFoodCommand(
                resource.foodId(),
                resource.amount(),
                resource.unit()
        );
    }
}
