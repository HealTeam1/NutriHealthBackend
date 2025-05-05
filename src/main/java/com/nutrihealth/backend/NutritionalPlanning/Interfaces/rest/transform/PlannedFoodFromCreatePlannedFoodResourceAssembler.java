package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;

public class PlannedFoodFromCreatePlannedFoodResourceAssembler {
    public static PlannedFood toEntityFromResource(CreatePlannedFoodResource resource){
        return new PlannedFood(
                CreatePlannedFoodCommandFromResourceAssembler.toCommandFromResource(resource)
        );

    }
}
