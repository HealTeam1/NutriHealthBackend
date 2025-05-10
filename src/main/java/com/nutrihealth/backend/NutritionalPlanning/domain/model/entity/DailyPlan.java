package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.ScheduledMealCommands.UpdateScheduledMealCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "daily_plans")
@Getter
@Setter
public class DailyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nutritional_plan_id", nullable = false)
    @JsonBackReference
    private NutritionalPlan nutritionalPlan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeekDay weekDay;


    @OneToMany(mappedBy = "dailyPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ScheduledMeal> scheduledMeals = new ArrayList<>();

    protected DailyPlan() {
    }

    public DailyPlan(CreateDailyPlanCommand command) {
        this.weekDay = command.weekDay();
        if (command.scheduledMeals() != null) {
            command.scheduledMeals().forEach(cmd -> {
                ScheduledMeal scheduledMeal = new ScheduledMeal(cmd);
                addScheduledMeal(scheduledMeal);
            });
        }
    }

    public void update(UpdateDailyPlanCommand command) {
        this.weekDay = command.weekDay() == null ? this.weekDay : command.weekDay();
        if (command.scheduledMeals() != null) {
            command.scheduledMeals().forEach(this::updateScheduledMeal);
        }

    }

    public void updateScheduledMeal(UpdateScheduledMealCommand command) {
        this.scheduledMeals.forEach(scheduledMeal -> {
            scheduledMeal.update(command);
        });
    }


    public void addScheduledMeal(ScheduledMeal scheduledMeal) {
        scheduledMeal.setDailyPlan(this);
        this.scheduledMeals.add(scheduledMeal);
    }


}

