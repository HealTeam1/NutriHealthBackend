package com.nutrihealth.backend.NutritionalPlanning.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.Unit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlannedFoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "scheduled_meal", nullable = false)
    @JsonBackReference
    private ScheduledMeal scheduledMeal;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    //protected PlannedFoods() {}
}
