package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;

import java.util.Date;
import java.util.List;

public record UpdateNutritionalPlanCommand(
        Long userId,
        Long planId,
        String name,
        Date startDate,
        String description,
        boolean active,
        List<DailyPlan> dailyPlans
) {
}
