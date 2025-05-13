package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record DailyPlanResource(
        Long id,
        Long planId,
        WeekDay weekDay,
        List<ScheduledMealResource> scheduledMeals
) {

}
