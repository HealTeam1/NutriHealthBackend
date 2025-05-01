package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/nutritional-plans")
public class NutritionalPlanQueryController {

    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionalPlanQueryController(NutritionalPlanQueryServiceImpl queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{userId}/{planId}/daily-plans")
    public List<DailyPlan> getDailyPlansByUserIdAndPlanId(
            @PathVariable Long userId,
            @PathVariable Long planId
    ) {
        return queryService.getDailyPlanByUserId(userId, planId);
    }
    @GetMapping("/{planId}")
    public Optional<NutritionalPlan> getNutritionalPlanById(
            @PathVariable Long planId
    ) {

        return queryService.getNutritionalPlanById(planId);
    }
}