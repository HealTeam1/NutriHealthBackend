package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;

import java.util.Date;
import java.util.List;

public record CreateNutritionalPlanCommand(
        Long userId,
        Date startDate,
        String name,
        String description,
        Boolean active,
        List<CreateDailyPlanCommand> dailyPlans
) {
}
