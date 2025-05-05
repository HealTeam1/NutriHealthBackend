package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;

public class CreateDailyPlanCommandFromResourceAssembler {
    public static CreateDailyPlanCommand toCommandFromResource(CreateDailyPlanResource resource) {

        return new CreateDailyPlanCommand(
                resource.userId(),
                resource.planId(),
                resource.weekDay(),
                resource.scheduledMeals().stream().map(ScheduledMealFromCreateScheduledMealResourceAssembler::toEntityFromResource).toList()
        );
    }
}
