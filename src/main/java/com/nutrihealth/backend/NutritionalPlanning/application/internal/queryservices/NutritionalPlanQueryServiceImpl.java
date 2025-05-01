package com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.services.NutritionalPlanQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionalPlanQueryServiceImpl  implements NutritionalPlanQueryService {

    private final NutritionalPlanRepository repository;

    public NutritionalPlanQueryServiceImpl(NutritionalPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<NutritionalPlan> getNutritionalPlanById(Long planId) {
        return repository.findById(planId);
    }

    @Override
    public List<DailyPlan> getDailyPlanByUserId(Long userId, Long planId) {
        return repository.findByUserIdAndId(userId,planId)
                .map(NutritionalPlan::getDailyPlans)
                .orElse(List.of());
    }
}
