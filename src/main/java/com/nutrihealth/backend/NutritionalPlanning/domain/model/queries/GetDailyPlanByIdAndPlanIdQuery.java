package com.nutrihealth.backend.NutritionalPlanning.domain.model.queries;

public record GetDailyPlanByIdAndPlanIdQuery(
        Long userId,
        Long planId
) {
}
