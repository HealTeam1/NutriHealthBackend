package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.NutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;

public class NutritionalPlanResourceFromEntityAssembler {
    public static NutritionalPlanResource toResource(NutritionalPlan entity){
        return new NutritionalPlanResource(
                entity.getId(),
                entity.getUserId(),
                entity.getStartDate(),
                entity.getName(),
                entity.getDescription(),
                entity.getActive(),
                entity.getDailyPlans().stream().map(DailyPlanResourceFromEntityAssembler::toResource).toList()
        );
    }
}
