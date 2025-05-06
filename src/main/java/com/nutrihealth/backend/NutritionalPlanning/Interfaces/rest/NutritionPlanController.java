package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan.CreateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.NutritionPlan.NutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.*;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionPlanByUserIdAndId;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetUserNutritionalPlanQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping("/{userId}/nutritional-plan")
    public ResponseEntity<NutritionalPlanResource> createNutritionalPlan(@PathVariable Long userId,
                                                                         @RequestBody CreateNutritionalPlanResource resource) {
        Optional<NutritionalPlan> nutritionalPlan = commandService
                .handle(CreateNutritionalPlanCommandFromResourceAssembler.toCommandFromResource(resource, userId));
        if (nutritionalPlan.isEmpty()) {
            throw new RuntimeException("Could not create nutritional plan");
        }
        var nutritionalPlanCreated = nutritionalPlan.get();
        return new ResponseEntity<>(NutritionalPlanResourceFromEntityAssembler.toResourceFromEntity(nutritionalPlanCreated), CREATED);
    }
    @DeleteMapping("/{userId}/nutritional-plan/{planId}'")
    public void deleteNutritionalPlan(@PathVariable Long userId,
                                                      @PathVariable Long planId){
        var cmd = new DeleteNutritionPlanByUserIdAndId(userId, planId);
        commandService.handle(cmd);
    }
    @GetMapping("/{userId}/nutritional/plan")
    public ResponseEntity<List<NutritionalPlanResource>> getUserNutritionalPlans(@PathVariable Long userId){
        var query = new GetUserNutritionalPlanQuery(userId);
        return new ResponseEntity<>(ListNutritionalPlanResourceFromListEntityAssembler.toResourceFromEntity(queryService.handle(query)),CREATED);
    }
}

