package com.fixingsolutions.serviceType.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateServiceTypeRequest {
    private String description;
    private BigDecimal value;
}
