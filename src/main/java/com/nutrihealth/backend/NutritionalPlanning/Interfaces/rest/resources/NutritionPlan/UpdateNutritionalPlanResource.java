package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan;

import java.util.Date;

public record UpdateNutritionalPlanResource(
        String name,
        Date startDate,
        String description,
        boolean active
) {

}
