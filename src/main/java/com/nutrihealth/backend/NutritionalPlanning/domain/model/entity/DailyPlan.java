package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.CreateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
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
    private List<ScheduledMeal> scheduledMeals;

    protected DailyPlan() {}
    public DailyPlan(CreateDailyPlanCommand command) {
        this.weekDay = command.weekDay();
        this.scheduledMeals = command.scheduledMeals() == null ? new ArrayList<>() : command.scheduledMeals();
    }
    public ScheduledMeal getScheduledMeal(TimeDay timeDay){
        return this.scheduledMeals
                .stream()
                .filter(scheduledMeal -> scheduledMeal.getTimeDay().equals(timeDay))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Scheduled Meal not found"));
    }
    public void addScheduledMeal(ScheduledMeal scheduledMeal){
        scheduledMeal.setDailyPlan(this);
        this.scheduledMeals.add(scheduledMeal);
    }
    public void updateDailyPlan(UpdateDailyPlanCommand command){
        this.weekDay = command.weekDay() == null ? this.weekDay : command.weekDay();
        this.scheduledMeals = command.scheduledMeals() == null ? this.scheduledMeals : command.scheduledMeals();
    }


}

