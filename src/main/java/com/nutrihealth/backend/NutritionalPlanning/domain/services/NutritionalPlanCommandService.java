package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.DeletePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.UpdatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateRecipeCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

import java.util.Optional;

public interface NutritionalPlanCommandService {
    Optional<NutritionalPlan> handle(CreateNutritionalPlanCommand command);
    void handle(DeleteNutritionalPlanCommand command);
    Optional<NutritionalPlan> handle(UpdateNutritionalPlanCommand command, Long planId);

    Optional<DailyPlan> handle(CreateDailyPlanCommand command, Long planId);

    Optional<ScheduledMeal> handle(UpdateRecipeCommand command, Long scheduledMealId);

    Optional<PlannedFood> handle(CreatePlannedFoodCommand command, Long scheduledMealId);

    void handle(DeletePlannedFoodCommand command);

    Optional<PlannedFood> handle(UpdatePlannedFoodCommand command, Long plannedFoodId);

}
