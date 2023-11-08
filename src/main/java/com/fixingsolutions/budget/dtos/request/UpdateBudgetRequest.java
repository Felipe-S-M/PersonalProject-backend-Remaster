package com.fixingsolutions.budget.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBudgetRequest {
    @NotNull(message = "Id cannot be null")
    private Integer id;
    @NotNull(message = "ExpectedHours cannot be null")
    private Integer expectedHours;
    @NotNull(message = "IsApproved cannot be null")
    private Boolean isApproved;
    @NotNull(message = "Customer cannot be null")
    private Integer customerId;
    @NotNull(message = "ServicesTypes cannot be null")
    private List<Integer> servicesTypesIds;
}
