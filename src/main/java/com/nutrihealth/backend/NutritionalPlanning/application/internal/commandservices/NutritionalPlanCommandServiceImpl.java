package com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.PlannedFoodRepository;
import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.ScheduledMealRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.DeletePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.UpdatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateRecipeCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.services.NutritionalPlanCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NutritionalPlanCommandServiceImpl implements NutritionalPlanCommandService {
    private final NutritionalPlanRepository repository;
    private final ScheduledMealRepository repositoryMeal;
    private final PlannedFoodRepository repositoryFood;

    public NutritionalPlanCommandServiceImpl(NutritionalPlanRepository repository, ScheduledMealRepository repositoryMeal, PlannedFoodRepository repositoryFood) {

        this.repository = repository;
        this.repositoryMeal = repositoryMeal;
        this.repositoryFood = repositoryFood;
    }

    @Override
    public Optional<NutritionalPlan> handle(CreateNutritionalPlanCommand command) {
        var plan = new NutritionalPlan(command);
        repository.save(plan);
        return Optional.of(plan);
    }

    @Override
    public void handle(DeleteNutritionalPlanCommand command) {
        Optional<NutritionalPlan> plan = repository.findById(command.nutritionalPlanId());
        if (plan.isEmpty()) {
            throw new IllegalArgumentException("No such NutritionalPlan");
        }
        repository.delete(plan.get());
    }

    @Override
    public Optional<NutritionalPlan> handle(UpdateNutritionalPlanCommand command, Long planId) {
        Optional<NutritionalPlan> plan = repository.findById(planId);
        if (plan.isEmpty()){
            throw new IllegalArgumentException("No such NutritionalPlan");
        }
        var planFinded= plan.get();
        planFinded.update(command);
        repository.save(planFinded);
        return Optional.of(planFinded);
    }

    @Override
    public Optional<DailyPlan> handle(CreateDailyPlanCommand command,Long planId) {
        var plan = repository.findById(planId);
        if (plan.isEmpty()) {
            throw new IllegalArgumentException("No such NutritionalPlan");
        }
        DailyPlan dailyPlan = new DailyPlan(command);
        plan.get().addDailyPlan(dailyPlan);
        /*
        TODO: VERIFICAR QUE EL DIA NO SEA EL MISMO QUE OTRO DIA
         */
        repository.save(plan.get());
        return Optional.of(dailyPlan);
    }

    @Override
    public Optional<ScheduledMeal> handle(UpdateRecipeCommand command, Long scheduledMealId) {
        Optional<ScheduledMeal> scheduledMeal = repositoryMeal.findById(scheduledMealId);
        if (scheduledMeal.isEmpty()) {
            throw new IllegalArgumentException("No such ScheduledMeal");
        }
        var sm = scheduledMeal.get();
        sm.setRecipeId(command.recipeId());
        repositoryMeal.save(sm);
        return Optional.of(sm);
    }

    @Override
    public Optional<PlannedFood> handle(CreatePlannedFoodCommand command, Long scheduledMealId) {
        Optional<ScheduledMeal> scheduledMeal = repositoryMeal.findById(scheduledMealId);
        if (scheduledMeal.isEmpty()) {
            throw new IllegalArgumentException("No such ScheduledMeal");
        }
        PlannedFood plannedFood = new PlannedFood(command);
        scheduledMeal.get().addPlannedFood(plannedFood);
        repositoryMeal.save(scheduledMeal.get());
        return Optional.of(plannedFood);
    }

    @Override
    public void handle(DeletePlannedFoodCommand command) {
        Optional<PlannedFood> plannedFood = repositoryFood.findById(command.id());
        if (plannedFood.isEmpty()) {
            throw new IllegalArgumentException("No such PlannedFood");
        }
        repositoryFood.delete(plannedFood.get());
    }

    @Override
    public Optional<PlannedFood> handle(UpdatePlannedFoodCommand command, Long plannedFoodId) {
        Optional<PlannedFood> plannedFood = repositoryFood.findById(plannedFoodId);
        if (plannedFood.isEmpty()) {
            throw new IllegalArgumentException("No such PlannedFood");
        }
        plannedFood.get().update(command);
        repositoryFood.save(plannedFood.get());
        var pf = plannedFood.get();
        return Optional.of(pf);
    }


}
