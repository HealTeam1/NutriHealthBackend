package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.DeleteDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionPlanByUserIdAndId;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateActiveNutritionPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.CreatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetDailyPlanByIdAndPlanIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetNutritionalPlanByIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController
//@RequestMapping("/api/v1/nutritional-plans")
//public class NutritionalPlanCommandController {
//
//    private final NutritionalPlanCommandServiceImpl commandService;
//    private final NutritionalPlanQueryServiceImpl queryService;
//
//    public NutritionalPlanCommandController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
//        this.commandService = commandService;
//        this.queryService = queryService;
//    }
//    /*
//    @PostMapping
//    public ResponseEntity<NutritionalPlan> createPlan(@RequestBody CreateNutritionalPlanCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    @DeleteMapping("/{userId}/{planId}")
//    public ResponseEntity<Void> deletePlan(@PathVariable Long userId, @PathVariable Long planId) {
//        commandService.handle(new DeleteNutritionPlanByUserIdAndId(userId, planId));
//        return ResponseEntity.noContent().build();
//    }
//
//    @PatchMapping("/{userId}/{planId}/active")
//    public ResponseEntity<NutritionalPlan> updateActive(@PathVariable Long userId,
//                                                        @PathVariable Long planId,
//                                                        @RequestBody UpdateActiveNutritionPlanCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    @PutMapping("/{userId}/{planId}")
//    public ResponseEntity<NutritionalPlan> updatePlan(@PathVariable Long userId,
//                                                      @PathVariable Long planId,
//                                                      @RequestBody UpdateNutritionalPlanCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/{userId}/{planId}/daily-plan")
//    public ResponseEntity<DailyPlan> createDailyPlan(@PathVariable Long userId,
//                                                     @PathVariable Long planId,
//                                                     @RequestBody CreateDailyPlanCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//     */
//    // GET nutritional plan by id
//    @GetMapping("/{planId}")
//    public ResponseEntity<NutritionalPlan> getNutritionalPlanById(@PathVariable Long planId) {
//        return queryService.handle(new GetNutritionalPlanByIdQuery(planId))
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // GET daily plans by user and plan id
//    @GetMapping("/{planId}/users/{userId}/daily-plans")
//    public ResponseEntity<List<DailyPlan>> getDailyPlansByUserAndPlanId(@PathVariable Long userId, @PathVariable Long planId) {
//        List<DailyPlan> dailyPlans = queryService.handle(new GetDailyPlanByIdAndPlanIdQuery(userId, planId));
//        return ResponseEntity.ok(dailyPlans);
//    }
//    /*
//    @DeleteMapping("/{userId}/{planId}/daily-plan/{weekDay}")
//    public ResponseEntity<Void> deleteDailyPlan(@PathVariable Long userId,
//                                                @PathVariable Long planId,
//                                                @PathVariable WeekDay weekDay) {
//        commandService.handle(new DeleteDailyPlanCommand(userId, planId, weekDay));
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{userId}/{planId}/daily-plan/{dailyPlanId}")
//    public ResponseEntity<DailyPlan> updateDailyPlan(@PathVariable Long userId,
//                                                     @PathVariable Long planId,
//                                                     @PathVariable Long dailyPlanId,
//                                                     @RequestBody UpdateDailyPlanCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//    @PostMapping("/scheduled-meals")
//    public ResponseEntity<ScheduledMeal> createScheduledMeal(@RequestBody CreateScheduledMealCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//    @PostMapping("/planned-foods")
//    public ResponseEntity<PlannedFood> addPlannedFood(@RequestBody CreatePlannedFoodCommand command) {
//        return commandService.handle(command)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.badRequest().build());
//    }
//
//     */
//
//}