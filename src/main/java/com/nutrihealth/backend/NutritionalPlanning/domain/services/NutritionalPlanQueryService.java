package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;

import java.util.List;
import java.util.Optional;

public interface NutritionalPlanQueryService {
    Optional<NutritionalPlan> getNutritionalPlanById(Long planId);
    List<DailyPlan> getDailyPlanByUserId(Long userId,Long PlanId);
}
