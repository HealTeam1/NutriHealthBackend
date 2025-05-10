package com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.DailyPlanCommands.UpdateDailyPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.CreateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.commands.NutritionPlanCommands.UpdateNutritionalPlanCommand;
import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
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

    public void update(UpdateNutritionalPlanCommand command){
        this.startDate = command.startDate() == null ? this.startDate : command.startDate();
        this.name= command.name() == null ? this.name : command.name();
        this.description = command.description() == null ? this.description : command.description();
        this.active = command.active() ;
        if(command.dailyPlans() != null) {
            command.dailyPlans().forEach(this::updateDailyPlan);
        }

    }

    public void addDailyPlan(DailyPlan dailyPlan){
        dailyPlan.setNutritionalPlan(this);
        this.dailyPlans.add(dailyPlan);
    }
    public void updateDailyPlan(UpdateDailyPlanCommand command){
        dailyPlans.forEach(dailyPlan -> {
            dailyPlan.update(command);
        });
    }

}
