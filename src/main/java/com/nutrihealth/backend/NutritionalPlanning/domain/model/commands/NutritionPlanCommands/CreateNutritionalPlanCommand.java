package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public record CreateNutritionalPlanCommand(
        Long userId,
        Date startDate,
        String name,
        String description,
        Boolean active,
        List<CreateDailyPlanCommand> dailyPlans
) {
}
