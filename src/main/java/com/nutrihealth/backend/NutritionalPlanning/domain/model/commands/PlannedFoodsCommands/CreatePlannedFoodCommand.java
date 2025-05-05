package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

public record CreatePlannedFoodCommand(
        Long userId,
        Long planId,
        Integer amount,
        Unit unit,
        WeekDay weekDay,
        TimeDay timeDay
) {

}
