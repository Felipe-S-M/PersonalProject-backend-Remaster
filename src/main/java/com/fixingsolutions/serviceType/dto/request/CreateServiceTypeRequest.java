package com.fixingsolutions.serviceType.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateServiceTypeRequest {
    @NotNull(message = "Description cannot be null")
    private String description;
    @NotNull(message = "Value cannot be null")
    private BigDecimal value;
}
