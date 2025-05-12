package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreateDailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.DailyPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create.CreateDailyPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dailyplan")
public class DailyPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;

    public DailyPlanController(NutritionalPlanCommandServiceImpl commandService) {
        this.commandService = commandService;
    }

//    @PostMapping("/add-dailyPlan")
//    public ResponseEntity<DailyPlanResource> createDailyPlan(@RequestBody CreateDailyPlanResource resource){
//
////        commandService.handle(CreateDailyPlanCommandFromResourceAssembler.toCommand(resource),resource.id())
//        return null
//    }

}
