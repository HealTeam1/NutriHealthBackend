package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public class ScheduledMealFromCreateScheduledMealResourceAssembler {
    public static ScheduledMeal toEntityFromResource(CreateScheduledMealResource resource,
                                                     Long userId,
                                                     Long planId,
                                                     WeekDay weekDay){
        return new ScheduledMeal(
                CreateScheduledMealCommandFromResourceAssembler.toCommandFromResource(resource,userId,planId,weekDay)
        );

    };
}
