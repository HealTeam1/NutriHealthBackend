package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan.NutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;

public class NutritionalPlanResourceFromEntityAssembler {
    public static NutritionalPlanResource toResourceFromEntity(NutritionalPlan entity){
        return new NutritionalPlanResource(
                entity.getUserId(),
                entity.getId(),
                entity.getStartDate(),
                entity.getName(),
                entity.getDescription(),
                entity.getActive(),
                entity.getDailyPlans().stream()
                        .map(DailyPlanResourceFromEntityAssembler::toResourceFromEntity)
                        .toList()
        );

    }
}
