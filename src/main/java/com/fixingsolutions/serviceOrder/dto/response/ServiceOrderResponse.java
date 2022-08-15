package com.fixingsolutions.serviceOrder.dto.response;

import com.fixingsolutions.budget.dtos.response.BudgetResponse;
import com.fixingsolutions.serviceOrder.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ServiceOrderResponse {
    private Long id;
    private Status status;
    private BudgetResponse budget;
    private Date lastUpdated;
}
