package com.fixingsolutions.budget.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class BudgetResponse {
    private Integer id;
    private BigDecimal value;
    private Integer expectedHours;
    private Boolean approved;
    private EmployeeResponse createdBy;
    private CustomerResponse customer;
}
