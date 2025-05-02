package com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetDailyPlanByIdAndPlanIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetNutritionalPlanByIdQuery;
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
    public Optional<NutritionalPlan> handle(GetNutritionalPlanByIdQuery query) {
        return repository.findById(query.planId());
    }

    @Override
    public List<DailyPlan> handle(GetDailyPlanByIdAndPlanIdQuery query) {
        return repository.findByUserIdAndId(query.userId(),query.planId())
                .map(NutritionalPlan::getDailyPlans)
                .orElse(List.of());
    }


}
