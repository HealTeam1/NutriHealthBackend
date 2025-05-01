package com.nutrihealth.backend.NutritionalPlanning.Infrastructure.persistence.jpa.repositories;

import com.nutrihealth.backend.NutritionalPlanning.domain.model.aggregates.NutritionalPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NutritionalPlanRepository extends JpaRepository<NutritionalPlan,Long> {
    List<NutritionalPlan> findAllByUserId(Long userId);
    Optional<NutritionalPlan> findByUserIdAndId(Long userId, Long planId);


}
