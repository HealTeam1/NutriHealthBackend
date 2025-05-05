package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public class CreateScheduledCommandFromResourceAssembler {
    public static CreateScheduledMealCommand toCommandFromResource(CreateScheduledMealResource resource,
                                                                   Long userId,
                                                                   Long planId,
                                                                   WeekDay weekDay){
        return new CreateScheduledMealCommand(
                userId,
                planId,
                weekDay,
                resource.recipeId(),
                resource.timeDay(),
                resource.plannedFoods().stream()
                        .map(pf -> PlannedFoodFromCreatePlannedFoodResource
                                .toEntityFromResource(pf,userId,planId,weekDay,resource.timeDay()))
                        .toList()
        );

    }
}
