package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionPlanByUserIdAndId;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateActiveNutritionPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetDailyPlanByIdAndPlanIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetNutritionalPlanByIdQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/nutritional-plans")
public class NutritionalPlanCommandController {

    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionalPlanCommandController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<NutritionalPlan> createPlan(@RequestBody CreateNutritionalPlanCommand command) {
        return commandService.handle(command)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{userId}/{planId}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long userId, @PathVariable Long planId) {
        commandService.handle(new DeleteNutritionPlanByUserIdAndId(userId, planId));
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{userId}/{planId}/active")
    public ResponseEntity<NutritionalPlan> updateActive(@PathVariable Long userId,
                                                        @PathVariable Long planId,
                                                        @RequestBody UpdateActiveNutritionPlanCommand command) {
        return commandService.handle(command)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{userId}/{planId}")
    public ResponseEntity<NutritionalPlan> updatePlan(@PathVariable Long userId,
                                                      @PathVariable Long planId,
                                                      @RequestBody UpdateNutritionalPlanCommand command) {
        return commandService.handle(command)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}/{planId}/daily-plan")
    public ResponseEntity<DailyPlan> createDailyPlan(@PathVariable Long userId,
                                                     @PathVariable Long planId,
                                                     @RequestBody CreateDailyPlanCommand command) {
        return commandService.handle(command)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    // GET nutritional plan by id
    @GetMapping("/{planId}")
    public ResponseEntity<NutritionalPlan> getNutritionalPlanById(@PathVariable Long planId) {
        return queryService.handle(new GetNutritionalPlanByIdQuery(planId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET daily plans by user and plan id
    @GetMapping("/{planId}/users/{userId}/daily-plans")
    public ResponseEntity<List<DailyPlan>> getDailyPlansByUserAndPlanId(@PathVariable Long userId, @PathVariable Long planId) {
        List<DailyPlan> dailyPlans = queryService.handle(new GetDailyPlanByIdAndPlanIdQuery(userId, planId));
        return ResponseEntity.ok(dailyPlans);
    }

}