package com.fixingsolutions.serviceOrder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateSORequest {
    private Integer budgetId;
    private String name;
}

