package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "daily_plans")
@Getter
@Setter
@NoArgsConstructor
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

    public DailyPlan(WeekDay weekDay) {
        this.weekDay = weekDay;
    }
    //protected DailyPlan() {}
    /*
    public void addScheduledMeal(ScheduledMeal meal) {
        this.scheduledMeals.add(meal);
        meal.setDailyPlan(this);
    }

    public void removeScheduledMeal(ScheduledMeal meal) {
        this.scheduledMeals.remove(meal);
        meal.setDailyPlan(null);
    }

    public int totalCalories() {
        return scheduledMeals.stream()
                .mapToInt(ScheduledMeal::totalCalories)
                .sum();
    }
    (
     */
}

