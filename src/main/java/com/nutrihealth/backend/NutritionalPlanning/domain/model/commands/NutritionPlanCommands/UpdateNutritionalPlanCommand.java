package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;

import java.util.Date;
import java.util.List;

public record UpdateNutritionalPlanCommand(
        String name,
        Date startDate,
        String description,
        boolean active,
        List<UpdateDailyPlanCommand> dailyPlans
) {
}
