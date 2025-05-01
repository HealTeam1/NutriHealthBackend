package com.nutrihealth.backend.NutritionalPlanning.domain.model.queries;

public record GetAllDailyPlanQuery(
        Long userId,
        Long planId
) {
}
