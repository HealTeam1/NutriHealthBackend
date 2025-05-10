package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;

import java.util.Optional;

public interface NutritionalPlanCommandService {
    Optional<NutritionalPlan> handle(CreateNutritionalPlanCommand command);
    void handle(DeleteNutritionalPlanCommand command);
    Optional<NutritionalPlan> handle(UpdateNutritionalPlanCommand command, Long planId);


}
