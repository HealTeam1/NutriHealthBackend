package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;

public class CreatePlannedFoodCommandFromResourceAssembler {
    public static CreatePlannedFoodCommand toCommandFromResource(CreatePlannedFoodResource resource) {
        return new CreatePlannedFoodCommand(
                resource.userId(),
                resource.planId(),
                resource.foodId(),
                resource.amount(),
                resource.unit(),
                resource.weekDay(),
                resource.timeDay()
        );
    }
}
