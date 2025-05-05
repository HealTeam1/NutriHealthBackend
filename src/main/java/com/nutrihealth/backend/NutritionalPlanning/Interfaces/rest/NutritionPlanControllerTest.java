package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.CreateDailyPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.DailyPlanResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/nutritional-plans")
public class NutritionPlanControllerTest {
    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionPlanControllerTest(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping("/{userId}/{planId}/dailyPlan")
    public ResponseEntity<DailyPlanResource> createDailyPlan(@PathVariable Long userId,
                                                             @PathVariable Long planId,
                                                             @RequestBody CreateDailyPlanResource resource){
        Optional<DailyPlan> dailyPlan = commandService
                .handle(CreateDailyPlanCommandFromResourceAssembler.toCommandFromResource(resource,userId,planId));
        if(dailyPlan.isEmpty()){
            throw new RuntimeException("Could not create daily plan");
        }
        var dailyProductCreated = dailyPlan.get();
        return new ResponseEntity<>(DailyPlanResourceFromEntityAssembler.toResourceFromEntity(dailyProductCreated),CREATED);
    }
}
