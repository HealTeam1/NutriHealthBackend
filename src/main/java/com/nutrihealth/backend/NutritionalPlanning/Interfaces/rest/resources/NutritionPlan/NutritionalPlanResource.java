package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.DailyPlanResource;

import java.util.Date;
import java.util.List;

public record NutritionalPlanResource(
        Long userId,
        Long planId,
        Date startDate,
        String name,
        String description,
        boolean active,
        List<DailyPlanResource> dailyPlans

) {
}
