package com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.entity.PlannedFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedFoodRepository  extends JpaRepository<PlannedFood,Long> {
}
