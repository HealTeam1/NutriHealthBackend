package com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
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
import com.nutrihealth.backend.NutritionalPlanning.domain.services.NutritionalPlanCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NutritionalPlanCommandServiceImpl implements NutritionalPlanCommandService {
    private final NutritionalPlanRepository repository;

    public NutritionalPlanCommandServiceImpl(NutritionalPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<NutritionalPlan> handle(CreateNutritionalPlanCommand command) {
        var plan = new NutritionalPlan(command);
        repository.save(plan);
        return Optional.of(plan);
    }

    @Override
    public Long handle(DeleteNutritionPlanByUserIdAndId command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        repository.delete(plan);
        return command.planId();
    }

    @Override
    public Optional<NutritionalPlan> handle(UpdateActiveNutritionPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(),command.planId() )
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        plan.setActive(command.active());
        repository.save(plan);
        return Optional.of(plan);
    }

    @Override
    public Optional<NutritionalPlan> handle(UpdateNutritionalPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        plan.updateNutritionPlan(command);
        repository.save(plan);
        return Optional.of(plan);
    }

    @Override
    public Optional<DailyPlan> handle(CreateDailyPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        var dp = new DailyPlan(command);
        plan.addDailyPlan(dp);
        repository.save(plan);
        return Optional.of(dp);
    }

    @Override
    public void handle(DeleteDailyPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        plan.deleteDailyPlan(command.weekDay());
        repository.save(plan);

    }

    @Override
    public Optional<DailyPlan> handle(UpdateDailyPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        var dp = plan.getDailyPlan(command.weekDay());
        dp.updateDailyPlan(command);
        repository.save(plan);
        return Optional.of(dp);
    }

    @Override
    public Optional<ScheduledMeal> handle(CreateScheduledMealCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        var dp = plan.getDailyPlan(command.weekDay());
        var scheduledMeal = new ScheduledMeal(command);
        dp.addScheduledMeal(scheduledMeal);
        repository.save(plan);
        return Optional.of(scheduledMeal);
    }

    @Override
    public void handle(DeleteScheduledMealCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        plan.getDailyPlan(command.weekDay()).deleteScheduledMeal(command.timeDay());
        repository.save(plan);
    }

    @Override
    public Optional<PlannedFood> handle(CreatePlannedFoodCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan Not Founded"));
        var dp=plan.getDailyPlan(command.weekDay());
        var sm = dp.getScheduledMeal(command.timeDay());
        var plannedFood = new PlannedFood(command);
        sm.addPlannedFood(plannedFood);
        repository.save(plan);
        return Optional.of(plannedFood);
    }
}
