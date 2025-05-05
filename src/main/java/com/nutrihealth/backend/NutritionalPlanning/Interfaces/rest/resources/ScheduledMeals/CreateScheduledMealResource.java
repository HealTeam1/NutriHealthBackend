package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import java.util.List;

public record CreateScheduledMealResource(
        TimeDay timeDay,
        Long recipeId,
        List<CreatePlannedFoodResource> plannedFoods
) {

}
