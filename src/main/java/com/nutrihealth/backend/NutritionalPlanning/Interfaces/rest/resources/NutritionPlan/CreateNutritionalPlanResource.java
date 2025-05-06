package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;

import java.util.Date;
import java.util.List;

public record CreateNutritionalPlanResource(
        Date startDate,
        String name,
        String description,
        boolean active,
        List<CreateDailyPlanResource> dailyPlans
) {
}
