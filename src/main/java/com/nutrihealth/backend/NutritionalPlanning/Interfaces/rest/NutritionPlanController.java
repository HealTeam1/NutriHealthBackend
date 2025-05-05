package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.PlannedFoods.PlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.CreateScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.ScheduledMeals.ScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.*;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

/*
@RestController
@RequestMapping("/api/v1/nutritional-plans")
public class NutritionPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionPlanController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping("/daily-plan")
    public ResponseEntity<DailyPlanResource> createDailyPlan(@RequestBody CreateDailyPlanResource resource){
        Optional<DailyPlan> dailyPlan = commandService
                .handle(CreateDailyPlanCommandFromResourceAssembler.toCommandFromResource(resource));
        if(dailyPlan.isEmpty()){
            throw new RuntimeException("Could not create daily plan");
        }
        var dailyProductCreated = dailyPlan.get();

        return new ResponseEntity<>(DailyPlanResourceFromEntityAssembler.toResourceFromEntity(dailyProductCreated),CREATED);
    }
    @PostMapping("/scheduled-meal")
    public ResponseEntity<ScheduledMealResource> createScheduledMeal(@RequestBody CreateScheduledMealResource resource){
        Optional<ScheduledMeal> scheduledMeal = commandService
                .handle(CreateScheduledMealCommandFromCreateScheduledMealResourceAssembler.toCommandFromResource(resource));
        if(scheduledMeal.isEmpty()){
            throw new RuntimeException("Could not create scheduled meal");
        }
        var scheduledMealCreated = scheduledMeal.get();
        return new ResponseEntity<>(ScheduledMealResourceFromEntityAssembler.toResourceFromEntity(scheduledMealCreated),CREATED);
    }
    @PostMapping("/{userId}/{dailyPlanId}/planned-foods")
    public ResponseEntity<PlannedFoodResource> addPlannedFood(@RequestBody CreatePlannedFoodResource resource,
                                                              @PathVariable Long userId,
                                                              @PathVariable Long dailyPlanId){
        Optional<PlannedFood> plannedFood = commandService
                .handle(CreatePlannedFoodCommandFromResourceAssembler.toCommandFromResource(resource));
        if(plannedFood.isEmpty()){
            throw new RuntimeException("Could not create scheduled meal");
        }
        var plannedFoodCreated = plannedFood.get();
        return new ResponseEntity<>(PlannedFoodResourceFromEntityAssembler.toResourceFromEntity(plannedFoodCreated),CREATED);
    }
}

 */
