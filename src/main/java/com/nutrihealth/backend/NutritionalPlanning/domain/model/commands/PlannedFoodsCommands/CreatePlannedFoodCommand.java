package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public record CreatePlannedFoodCommand(
        Long userId,
        Long planId,
        WeekDay weekDay,
        TimeDay timeDay,
        Long foodId,
        Integer amount,
        Unit unit
) {

}
