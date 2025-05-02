package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    public DailyPlan(NutritionalPlan plan,WeekDay weekDay) {
        this.nutritionalPlan = plan;
        this.weekDay = weekDay;
        this.scheduledMeals = new ArrayList<>();
    }

}

