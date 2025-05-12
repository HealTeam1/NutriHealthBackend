package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources;

import java.util.Date;
import java.util.List;

public record NutritionalPlanResource(
        Long id,
        Long userId,
        Date startDate,
        String name,
        String description,
        Boolean active,
        List<DailyPlanResource> dailyPlans
) {

}
