package com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.ScheduledMeal;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.TimeDay;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.valueobjects.WeekDay;
import com.nutrihealth.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class NutritionalPlan extends AuditableAbstractAggregateRoot<NutritionalPlan> {

    @Column(nullable = false)
    private Long userId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "nutritionalPlan", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<DailyPlan> dailyPlans = new ArrayList<>();
    protected NutritionalPlan() {}

    public NutritionalPlan(CreateNutritionalPlanCommand command) {
        this.userId = command.userId();
        this.startDate = command.startDate();
        this.name = command.name();
        this.description = command.description();
        this.active = command.active();
        if (command.dailyPlans() != null) {
            command.dailyPlans().forEach(dailyPlan -> {
                DailyPlan dp = new DailyPlan(dailyPlan);
                addDailyPlan(dp);
            });
        }
    }

    public void updateNutritionPlan(UpdateNutritionalPlanCommand command){
        this.startDate = command.startDate();
        this.name= command.name();
        this.active = command.active();
        this.description = command.description();
    }

    public void addDailyPlan(DailyPlan dailyPlan){
        dailyPlan.setNutritionalPlan(this);
        this.dailyPlans.add(dailyPlan);
    }
    public DailyPlan getDailyPlan(WeekDay weekDay){
        return this.dailyPlans
                .stream()
                .filter(dp->dp.getWeekDay().equals(weekDay))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Daily Plan not found"));
    }
    public void deleteDailyPlan(WeekDay weekDay){
        this.dailyPlans.removeIf(dp->dp.getWeekDay().equals(weekDay));
    }

}
