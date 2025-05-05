package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.ScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record DailyPlanResource(
        Long dailyId,
        Long planId,
        WeekDay weekDay,
        List<ScheduledMealResource> scheduledMeals
) {
}
