package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.DeleteDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionPlanByUserIdAndId;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateActiveNutritionPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;

import java.util.Optional;

public interface NutritionalPlanCommandService {
    Optional<NutritionalPlan> handle(CreateNutritionalPlanCommand command);
    Long handle(DeleteNutritionPlanByUserIdAndId command);
    Optional<NutritionalPlan> handle(UpdateActiveNutritionPlanCommand command);
    Optional<NutritionalPlan> handle(UpdateNutritionalPlanCommand command);
    Optional<DailyPlan> handle(CreateDailyPlanCommand command);
    void handle(DeleteDailyPlanCommand command);
    Optional<DailyPlan> handle(UpdateDailyPlanCommand command);
    Optional<ScheduledMeal> handle(CreateScheduledMealCommand command);

}
