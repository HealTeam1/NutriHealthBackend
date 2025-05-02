package com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionPlanByUserIdAndId;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateActiveNutritionPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
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
        Optional<NutritionalPlan> plan = repository.findByUserIdAndId(command.userId(), command.planId());
        if (plan.isEmpty()) {
            throw new IllegalArgumentException("Plan no encontrado");
        }
        repository.delete(plan.get());
        return command.planId();
    }

    @Override
    public Optional<NutritionalPlan> handle(UpdateActiveNutritionPlanCommand command) {
        Optional<NutritionalPlan> plan = repository.findByUserIdAndId(command.userId(), command.planId());
        if (plan.isEmpty()) {
            throw new IllegalArgumentException("Plan no encontrado");
        }
        var updatedPlan = plan.get();
        updatedPlan.setActive(command.active());
        repository.save(updatedPlan);
        return Optional.of(updatedPlan);
    }

    @Override
    public Optional<NutritionalPlan> handle(UpdateNutritionalPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan no encontrado"));
        plan.updateNutritionPlan(command);
        repository.save(plan);
        return Optional.of(plan);
    }

    @Override
    public Optional<DailyPlan> handle(CreateDailyPlanCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan no encontrado"));
        var dailyPlan = new DailyPlan(plan, command.weekDay());
        plan.addDailyPlan(dailyPlan);
        repository.save(plan);
        return Optional.of(dailyPlan);
    }

    @Override
    public Optional<ScheduledMeal> handle(CreateScheduledMealCommand command) {
        var plan = repository.findByUserIdAndId(command.userId(), command.planId())
                .orElseThrow(() -> new IllegalArgumentException("Plan no encontrado"));
        var dailyplan = plan.getDailyPlans()
                .stream()
                .filter(dailyPlan -> dailyPlan.getId().equals(command.dailyPlanId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dia no encontrado"));
        var scheduledMeal = new ScheduledMeal(dailyplan, command);
        dailyplan.getScheduledMeals().add(scheduledMeal);
        repository.save(plan);
        return Optional.of(scheduledMeal);
    }
}
