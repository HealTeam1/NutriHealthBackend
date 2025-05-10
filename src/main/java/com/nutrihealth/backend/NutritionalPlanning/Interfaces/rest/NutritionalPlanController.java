package com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest;

import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.resources.CreateNutritionalPlanResource;
import com.nutrihealth.backend.NutritionalPlanning.Interfaces.rest.transform.create.CreateNutritionalPlanCommandFromResourceAssembler;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.commandservices.NutritionalPlanCommandServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.application.internal.queryservices.NutritionalPlanQueryServiceImpl;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.DeleteNutritionalPlanCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/nutrition-plan")
public class NutritionalPlanController {
    private final NutritionalPlanCommandServiceImpl commandService;
    private final NutritionalPlanQueryServiceImpl queryService;

    public NutritionalPlanController(NutritionalPlanCommandServiceImpl commandService, NutritionalPlanQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<NutritionalPlan> createNutritionalPlan(@PathVariable Long userId,
                                                                 @RequestBody CreateNutritionalPlanResource resource
                                                                 ) {
        Optional<NutritionalPlan> nutritionalPlan= commandService.handle(CreateNutritionalPlanCommandFromResourceAssembler.toCommand(resource,userId));

        return nutritionalPlan.map(plan -> new ResponseEntity<>(plan, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{planId}")
    public ResponseEntity<Void> deleteNutritionalPlan(@PathVariable Long planId) {
        DeleteNutritionalPlanCommand cmd = new DeleteNutritionalPlanCommand(planId);
        commandService.handle(cmd);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
