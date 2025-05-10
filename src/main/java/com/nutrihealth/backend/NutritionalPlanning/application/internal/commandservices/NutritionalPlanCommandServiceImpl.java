package com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
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
}
