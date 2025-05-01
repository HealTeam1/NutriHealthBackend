package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<PlannedFoods> plannedFoods;

    //protected ScheduledMeal() {}
}
