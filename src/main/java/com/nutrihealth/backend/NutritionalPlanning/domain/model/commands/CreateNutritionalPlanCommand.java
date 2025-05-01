package com.nutrihealth.backend.NutritionalPlanning.domain.model.commands;

import java.util.Date;
import java.util.Optional;

public record CreateNutritionalPlanCommand(
        Long userId,
        Date startDate,
        String name,
        Optional<String> description,
        Boolean active
) {
}
