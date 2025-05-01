package com.nutrihealth.backend.NutritionalPlanning.Infrastructure.bootstrap;

import com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories.NutritionalPlanRepository;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFoods;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class BootstrapData {

    private final NutritionalPlanRepository planRepository;

    public BootstrapData(NutritionalPlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @PostConstruct
    public void insertData() {
        // Crear plan nutricional
        CreateNutritionalPlanCommand command = new CreateNutritionalPlanCommand(
                1L,
                new Date(),
                "Plan Semanal",
                Optional.of("Plan de prueba para la semana"),
                true
        );
        NutritionalPlan plan = new NutritionalPlan(command);

        // Crear día
        DailyPlan monday = new DailyPlan(WeekDay.MONDAY);
        monday.setNutritionalPlan(plan);

        // Crear comida agendada
        ScheduledMeal meal = new ScheduledMeal();
        meal.setDailyPlan(monday);
        meal.setRecipeId(123L); // solo si aplica
        meal.setTimeDay(TimeDay.BREAKFAST);

        // Crear alimentos planificados
        PlannedFoods food1 = new PlannedFoods();
        food1.setScheduledMeal(meal);
        food1.setAmount(100);
        food1.setUnit(Unit.GRAM);

        PlannedFoods food2 = new PlannedFoods();
        food2.setScheduledMeal(meal);
        food2.setAmount(1);
        food2.setUnit(Unit.PIECE);

        meal.setPlannedFoods(List.of(food1, food2));
        monday.setScheduledMeals(List.of(meal));
        plan.setDailyPlans(List.of(monday));

        // Guardar todo
        planRepository.save(plan);
    }
}
