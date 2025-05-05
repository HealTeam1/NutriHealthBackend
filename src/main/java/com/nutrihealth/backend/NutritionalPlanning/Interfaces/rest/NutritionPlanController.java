package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.CreateDailyPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.DailyPlanResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/nutritional-plans")
public class NutritionPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionPlanController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<DailyPlanResource> createDailyPlan(@RequestBody CreateDailyPlanResource resource){
        Optional<DailyPlan> dailyPlan = commandService
                .handle(CreateDailyPlanCommandFromResourceAssembler.toCommandFromResource(resource));
        if(dailyPlan.isEmpty()){
            throw new RuntimeException("Could not create daily plan");
        }
        var dailyProductCreated = dailyPlan.get();

        return new ResponseEntity<>(DailyPlanResourceFromEntityAssembler.toResourceFromEntity(dailyProductCreated),CREATED);
    }
}
