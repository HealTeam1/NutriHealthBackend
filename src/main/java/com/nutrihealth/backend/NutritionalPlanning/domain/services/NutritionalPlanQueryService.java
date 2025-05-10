package com.nutrihealth.backend.NutritionalPlanning.domain.services;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetAllNutritionalPlanByUserIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetDailyPlanByIdAndPlanIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetNutritionalPlanByIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetUserNutritionalPlanQuery;

import java.util.List;
import java.util.Optional;

public interface NutritionalPlanQueryService {
    Optional<List<NutritionalPlan>> handle(GetAllNutritionalPlanByUserIdQuery query);


}
