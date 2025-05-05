package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.PlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;

public class PlannedFoodResourceFromEntityAssembler {
    public static PlannedFoodResource toResourceFromEntity(PlannedFood entity){
        return new PlannedFoodResource(
                entity.getId(),
                entity.getFoodId(),
                entity.getAmount(),
                entity.getUnit()
        );
    }
}
