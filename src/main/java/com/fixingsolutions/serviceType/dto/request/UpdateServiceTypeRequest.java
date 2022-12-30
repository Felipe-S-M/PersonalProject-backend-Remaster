package com.fixingsolutions.serviceType.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateServiceTypeRequest {
    @NotNull(message = "Id cannot be null")
    private Integer id;
    @NotNull(message = "Description cannot be null")
    private String description;
    @NotNull(message = "Value cannot be null")
    private BigDecimal value;
}
