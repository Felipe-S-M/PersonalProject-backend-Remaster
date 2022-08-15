package com.fixingsolutions.serviceOrder;

import com.fixingsolutions.budget.BudgetMapper;
import com.fixingsolutions.budget.entity.Budget;
import com.fixingsolutions.serviceOrder.dto.response.ServiceOrderResponse;
import com.fixingsolutions.serviceOrder.entity.ServiceOrder;
import com.fixingsolutions.serviceOrder.entity.Status;

import java.util.Date;

public class ServiceOrderMapper {

    public static ServiceOrder buildNewServiceOrder(Budget budget, String name) {
        return ServiceOrder.builder()
                .budget(budget)
                .name(name)
                .startedAt(new Date())
                .status(Status.ON_WAIT)
                .lastUpdated(new Date())
                .build();
    }

    public static ServiceOrderResponse buildResponse(ServiceOrder serviceOrder) {
        return ServiceOrderResponse.builder()
                .id(serviceOrder.getId())
                .budget(BudgetMapper.buildBudgetResponse(serviceOrder.getBudget()))
                .lastUpdated(serviceOrder.getLastUpdated())
                .status(serviceOrder.getStatus())
                .build();
    }
}
