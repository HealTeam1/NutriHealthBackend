package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;

public class CreatePlannedFoodCommandFromResourceAssembler {
    public static CreatePlannedFoodCommand toCommand(CreatePlannedFoodResource resource) {
        return new CreatePlannedFoodCommand(
                resource.foodId(),
                resource.amount(),
                resource.unit()
        );
    }
}
