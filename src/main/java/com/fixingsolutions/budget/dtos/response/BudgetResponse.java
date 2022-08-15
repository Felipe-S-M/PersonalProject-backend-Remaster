package com.fixingsolutions.budget.dtos.response;

import com.fixingsolutions.customer.dtos.response.CustomerResponse;
import com.fixingsolutions.employee.dto.response.EmployeeResponse;
import com.fixingsolutions.serviceType.dto.response.ServiceTypeResponse;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class BudgetResponse {
    private Long id;
    private BigDecimal value;
    private Integer expectedHours;
    private Boolean approved;
    private EmployeeResponse createdBy;
    private CustomerResponse customer;
    private List<ServiceTypeResponse> services;
}
