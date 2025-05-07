package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.DailyPlan.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.CreateDailyPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.DailyPlanResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.DeleteDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.DeleteScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetDailyPlanByIdAndPlanIdQuery;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/daily-plans")
public class DailyPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public DailyPlanController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }
    @PostMapping("/{userId}/{planId}/dailyPlan")
    public ResponseEntity<DailyPlanResource> createDailyPlan(@PathVariable Long userId,
                                                             @PathVariable Long planId,
                                                             @RequestBody CreateDailyPlanResource resource) {
        Optional<DailyPlan> dailyPlan = commandService
                .handle(CreateDailyPlanCommandFromResourceAssembler.toCommandFromResource(resource, userId, planId));
        if (dailyPlan.isEmpty()) {
            throw new RuntimeException("Could not create daily plan");
        }
        var dailyProductCreated = dailyPlan.get();
        return new ResponseEntity<>(DailyPlanResourceFromEntityAssembler.toResourceFromEntity(dailyProductCreated), CREATED);
    }
    @DeleteMapping("/{userId}/{planId}/{weekDay}")
    public ResponseEntity<WeekDay> deleteDailyPlan(
            @PathVariable Long userId,
            @PathVariable Long planId,
            @PathVariable WeekDay weekDay
            ){

        commandService.handle( new DeleteDailyPlanCommand(userId,planId,weekDay));
        return new ResponseEntity<>(weekDay, OK);
    }
    @GetMapping("/{userId}/{planId}/dailyPlan")
    public ResponseEntity<List<DailyPlanResource>> getDailyPlansByPlanId(@PathVariable Long userId,
                                                                     @PathVariable Long planId) {
        var dailyPLans =queryService.handle(new GetDailyPlanByIdAndPlanIdQuery(userId,planId));
        return new ResponseEntity<>(dailyPLans.stream().map(DailyPlanResourceFromEntityAssembler::toResourceFromEntity).toList(), OK);
    }
    @DeleteMapping("/{userId}/{planId}/{weekDay}/{timeDay}")
    public ResponseEntity<Void> deleteScheduledMeal(@PathVariable Long userId,
                                                    @PathVariable Long planId,
                                                    @PathVariable WeekDay weekDay,
                                                    @PathVariable TimeDay timeDay){
        var cmd = new DeleteScheduledMealCommand(userId,planId,weekDay,timeDay);
        commandService.handle(cmd);
        return new ResponseEntity<>(OK);
    }
}
