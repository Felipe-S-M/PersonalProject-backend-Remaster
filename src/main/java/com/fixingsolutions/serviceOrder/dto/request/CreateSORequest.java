package com.fixingsolutions.serviceOrder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateSORequest {
    @NotNull(message = "Budget cannot be null")
    private Integer budgetId;
    @NotNull(message = "Name cannot be null")
    private String name;
}

