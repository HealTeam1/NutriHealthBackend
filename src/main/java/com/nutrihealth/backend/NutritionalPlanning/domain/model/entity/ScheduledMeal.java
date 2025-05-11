package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.PlannedFoodsCommands.UpdatePlannedFoodCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.CreateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Entity
@Getter
@Setter
public class ScheduledMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daily_plan_id", nullable = false)
    @JsonBackReference
    private DailyPlan dailyPlan;

    @Column(nullable = true)
    private Long recipeId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TimeDay timeDay;


    @OneToMany(mappedBy = "scheduledMeal", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<PlannedFood> plannedFoods = new ArrayList<>();

    protected ScheduledMeal() {
    }

    public ScheduledMeal(CreateScheduledMealCommand command) {
        this.recipeId = command.recipeId() == null ? null : command.recipeId();
        this.timeDay = command.timeDay();
        if (command.plannedFoods() != null) {
            command.plannedFoods().forEach(
                    cmd -> {
                        PlannedFood plannedFood = new PlannedFood(cmd);
                        addPlannedFood(plannedFood);
                    });
        }
    }
    public void update(UpdateScheduledMealCommand command){
        this.timeDay= command.timeDay() == null ? this.timeDay : command.timeDay();
        this.recipeId= command.recipeFood() == null ? this.recipeId : command.recipeFood();
        if(plannedFoods!=null){
            Map<Long,UpdatePlannedFoodCommand> mapCmd = command.plannedFoods().stream()
                    .filter(c->c.foodId()!=null)
                    .collect(toMap(c->c.foodId(),c->c));

            this.plannedFoods.forEach(plannedFood -> {
                if(mapCmd.containsKey(plannedFood.getId())){
                    plannedFood.update(mapCmd.get(plannedFood.getId()));
                }
                    }
            );
        }

    }


    public void addPlannedFood(PlannedFood plannedFood) {
        plannedFood.setScheduledMeal(this);
        this.plannedFoods.add(plannedFood);
    }

}
