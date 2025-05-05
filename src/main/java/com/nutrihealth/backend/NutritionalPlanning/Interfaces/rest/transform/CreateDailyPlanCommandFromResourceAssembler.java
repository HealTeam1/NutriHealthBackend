package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;

public class CreateDailyPlanCommandFromResourceAssembler {
    public static CreateDailyPlanCommand toCommandFromResource(CreateDailyPlanResource resource, Long userId, Long planId){
        return new CreateDailyPlanCommand(
                userId,
                planId,
                resource.weekDay(),
                resource.scheduledMeals().stream()
                        .map(sm-> ScheduledMealFromCreateScheduledMealResourceAssembler
                                .toEntityFromResource(sm,userId,planId,resource.weekDay()))
                        .toList()

        );

    }
}
