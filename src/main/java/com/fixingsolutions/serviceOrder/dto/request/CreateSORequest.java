package com.fixingsolutions.serviceOrder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateSORequest {
    private Long budgetId;
    private String name;
}

