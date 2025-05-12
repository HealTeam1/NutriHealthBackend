package com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
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
}
