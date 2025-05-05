package com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.DailyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyPlanRepository  extends JpaRepository<DailyPlan,Long>
{
}
