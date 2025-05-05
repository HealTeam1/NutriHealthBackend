package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.ScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record CreateDailyPlanResource(
        WeekDay weekDay,
        List<CreateScheduledMealResource> scheduledMeals
) {
}
