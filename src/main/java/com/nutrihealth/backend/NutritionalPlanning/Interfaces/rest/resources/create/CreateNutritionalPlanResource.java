package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create;

import java.util.Date;
import java.util.List;

public record CreateNutritionalPlanResource(
        Long userId,
        Date startDate,
        String name,
        String description,
        Boolean active,
        List<CreateDailyPlanResource> dailyPlans

) {
}
