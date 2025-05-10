package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.DeleteDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionPlanByUserIdAndId;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateActiveNutritionPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.DeleteScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

import java.util.Optional;

public interface NutritionalPlanCommandService {
    Optional<NutritionalPlan> handle(CreateNutritionalPlanCommand command);


}
