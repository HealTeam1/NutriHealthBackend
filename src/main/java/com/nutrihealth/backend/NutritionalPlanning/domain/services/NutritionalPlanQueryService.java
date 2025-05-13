package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetAllNutritionalPlanByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface NutritionalPlanQueryService {
    Optional<List<NutritionalPlan>> handle(GetAllNutritionalPlanByUserIdQuery query);




}
