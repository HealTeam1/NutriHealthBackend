package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;
import java.util.Optional;

public record CreateDailyPlanResource(
        WeekDay weekDay,
        List<CreateScheduledMealResource> scheduledMeals
) {
}
