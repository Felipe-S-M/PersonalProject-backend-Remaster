package com.fixingsolutions.serviceType.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ServiceTypeResponse {
    private String description;
    private BigDecimal value;
}
