package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.PlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;

public class PlannedFoodResourceFromEntityAssembler {
    public static PlannedFoodResource toResource(PlannedFood entity){
        return new PlannedFoodResource(
                entity.getFoodId(),
                entity.getAmount(),
                entity.getUnit()
        );
    }
}
