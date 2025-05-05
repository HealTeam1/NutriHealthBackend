package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public record CreatePlannedFoodResource(
        Long userId,
        Long planId,
        Long foodId,
        Integer amount,
        Unit unit,
        WeekDay weekDay,
        TimeDay timeDay
) {
}
