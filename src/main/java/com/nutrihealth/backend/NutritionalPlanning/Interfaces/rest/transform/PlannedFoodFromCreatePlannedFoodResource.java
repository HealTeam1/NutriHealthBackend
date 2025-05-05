package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public class PlannedFoodFromCreatePlannedFoodResource {
    public static PlannedFood toEntityFromResource(CreatePlannedFoodResource resource,
                                            Long userId,
                                            Long planId,
                                            WeekDay weekDay,
                                            TimeDay timeDay) {
        return new PlannedFood(
                CreatePlannedFoodCommandFromResourceAssembler.toCommandFromResource(resource,userId,planId,weekDay,timeDay)
        );
    }
}
