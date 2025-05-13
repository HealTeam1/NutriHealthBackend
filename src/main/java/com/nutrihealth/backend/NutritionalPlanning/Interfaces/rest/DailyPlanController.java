package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create.CreateDailyPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities.DailyPlanResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/dailyplan")
public class DailyPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;

    public DailyPlanController(NutritionalPlanCommandServiceImpl commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/{planId}/add-dailyPlan'")
    public ResponseEntity<DailyPlanResource> createDailyPlan(@PathVariable Long planId,
                                                             @RequestBody CreateDailyPlanResource resource) {
        var dailyPlan = commandService.handle(CreateDailyPlanCommandFromResourceAssembler.toCommand(resource), planId);
        var dailyPlanCreated = dailyPlan.get();
        return new ResponseEntity<>(DailyPlanResourceFromEntityAssembler.toResource(dailyPlanCreated),CREATED);
    }


}
