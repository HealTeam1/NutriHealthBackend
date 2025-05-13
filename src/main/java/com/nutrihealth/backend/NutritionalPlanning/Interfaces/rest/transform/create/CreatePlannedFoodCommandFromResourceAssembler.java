package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;

public class CreatePlannedFoodCommandFromResourceAssembler {
    public static CreatePlannedFoodCommand toCommand(CreatePlannedFoodResource resource) {
        return new CreatePlannedFoodCommand(
                resource.foodId(),
                resource.amount(),
                resource.unit()
        );
    }
}
