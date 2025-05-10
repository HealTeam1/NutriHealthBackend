package com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetAllNutritionalPlanByUserIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetDailyPlanByIdAndPlanIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetNutritionalPlanByIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetUserNutritionalPlanQuery;
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
    public Optional<List<NutritionalPlan>> handle(GetAllNutritionalPlanByUserIdQuery query) {
        var plans = repository.findAllByUserId(query.userId());
        if (plans.isEmpty()) {
            throw new IllegalArgumentException("No plans found for user id " + query.userId());
        }
        return Optional.of(plans);
    }
}
