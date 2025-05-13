package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.create.CreatePlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.NutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.PlannedFoodResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.entitiesResources.ScheduledMealResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create.CreateNutritionalPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create.CreatePlannedFoodCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities.NutritionalPlanResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities.PlannedFoodResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.entities.ScheduledMealResourceFromEntityAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.DeletePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateRecipeCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.queries.GetAllNutritionalPlanByUserIdQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/nutrition-plan")
public class NutritionalPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionalPlanController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping("/add-nutritional-plan")
    public ResponseEntity<NutritionalPlanResource> createNutritionalPlan(@RequestBody CreateNutritionalPlanResource resource
    ) {
        Optional<NutritionalPlan> nutritionalPlan = commandService.handle(CreateNutritionalPlanCommandFromResourceAssembler.toCommand(resource));
        var planCreated = nutritionalPlan.get();

        return new ResponseEntity<>(NutritionalPlanResourceFromEntityAssembler.toResource(planCreated), CREATED);


    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<Void> deleteNutritionalPlan(@PathVariable Long planId) {
        DeleteNutritionalPlanCommand cmd = new DeleteNutritionalPlanCommand(planId);
        commandService.handle(cmd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<NutritionalPlan>> getNutritionalPlan(@PathVariable Long userId) {
        GetAllNutritionalPlanByUserIdQuery query = new GetAllNutritionalPlanByUserIdQuery(userId);
        Optional<List<NutritionalPlan>> plans = queryService.handle(query);
        return new ResponseEntity<>(plans.get(), OK);
    }

    @PutMapping("/{planId}")
    public ResponseEntity<NutritionalPlan> updateNutritionalPlan(@PathVariable Long planId,
                                                                 @RequestBody UpdateNutritionalPlanCommand command) {
        var plan = commandService.handle(command, planId);

        return new ResponseEntity<>(plan.get(), OK);
    }

    @PutMapping("/scheduledMeal/{id}/set-recipe")
    public ResponseEntity<ScheduledMealResource> updateScheduledMeal(@PathVariable Long id,
                                                                     @RequestBody UpdateRecipeCommand resource) {
        var scheduledmeal = commandService.handle(resource, id).get();
        return new ResponseEntity<>(ScheduledMealResourceFromEntityAssembler.toResource(scheduledmeal), OK);
    }

    @PostMapping("/{scheduledMealId}/plannedFoods")
    public ResponseEntity<PlannedFoodResource> addPlannedFood(@PathVariable Long scheduledMealId,
                                                              @RequestBody CreatePlannedFoodResource resource) {
        var plannedFood = commandService.handle(CreatePlannedFoodCommandFromResourceAssembler.toCommand(resource),scheduledMealId).get();
        return new ResponseEntity<>(PlannedFoodResourceFromEntityAssembler.toResource(plannedFood), CREATED);
    }
    @DeleteMapping("/plannedFood/{id}")
    public ResponseEntity<Void> deletePlannedFood(@PathVariable Long id){
        var cmd = new DeletePlannedFoodCommand(id);
        commandService.handle(cmd);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
