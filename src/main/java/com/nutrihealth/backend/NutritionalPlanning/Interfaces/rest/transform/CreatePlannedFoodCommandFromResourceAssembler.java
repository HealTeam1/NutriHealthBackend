package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public class CreatePlannedFoodCommandFromResourceAssembler {
    public static CreatePlannedFoodCommand toCommandFromResource(CreatePlannedFoodResource resource,
                                                                 Long userId,
                                                                 Long planId,
                                                                 WeekDay weekDay,
                                                                 TimeDay timeDay) {
        return new CreatePlannedFoodCommand(
                userId,
                planId,
                weekDay,
                timeDay,
                resource.foodId(),
                resource.amount(),
                resource.unit()
        );

    }
}
