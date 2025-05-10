package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;

public class CreateDailyPlanCommandFromResourceAssembler {
    public static CreateDailyPlanCommand toCommand(CreateDailyPlanResource resource) {
        return new CreateDailyPlanCommand(
                resource.weekDay(),
                resource.scheduledMeals().stream()
                        .map(CreateScheduledMealCommandFromResourceAssembler::toCommand)
                        .toList()
        );
    }
}
