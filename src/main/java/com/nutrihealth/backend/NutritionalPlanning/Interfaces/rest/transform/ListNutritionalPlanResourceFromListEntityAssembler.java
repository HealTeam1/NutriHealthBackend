package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan.NutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;

import java.util.List;

public class ListNutritionalPlanResourceFromListEntityAssembler {
    public static List<NutritionalPlanResource> toResourceFromEntity(List<NutritionalPlan> entity){
        return entity.stream()
                .map(NutritionalPlanResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}
