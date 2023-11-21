package com.fixingsolutions.serviceOrder.service;

import com.fixingsolutions.budget.repository.BudgetRepository;
import com.fixingsolutions.serviceOrder.ServiceOrderMapper;
import com.fixingsolutions.serviceOrder.dto.request.CreateSORequest;
import com.fixingsolutions.serviceOrder.dto.request.UpdateSORequest;
import com.fixingsolutions.serviceOrder.dto.response.ServiceOrderResponse;
import com.fixingsolutions.serviceOrder.entity.ServiceOrder;
import com.fixingsolutions.serviceOrder.repository.ServiceOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceOrderService {
    private ServiceOrderRepository serviceOrderRepository;
    private BudgetRepository budgetRepository;

    public List<ServiceOrder> findAll() {
        return serviceOrderRepository.findAll();
    }

    public ServiceOrderResponse createServiceOrder(CreateSORequest request) throws Exception {
        var budget = budgetRepository.findById(request.getBudgetId())
                .orElseThrow(() -> new Exception("No budget found"));
        var serviceOrder = serviceOrderRepository
                .save(ServiceOrderMapper.buildNewServiceOrder(budget, request.getName()));
        return ServiceOrderMapper.buildResponse(serviceOrder);
    }

    public void deleteServiceOrder(Integer id) throws Exception {
        var serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new Exception("No service order found"));
        serviceOrderRepository.delete(serviceOrder);
    }

    public ServiceOrderResponse update(UpdateSORequest request) throws Exception {
        var serviceOrder = serviceOrderRepository.findById(request.getId())
                .orElseThrow(() -> new Exception("No service order found"));
        var budget = budgetRepository.findById(request.getBudgetId())
                .orElseThrow(() -> new Exception("No budget found"));
        serviceOrder.setBudget(budget);
        serviceOrder.setName(request.getName());
        serviceOrder.setStatus(request.getStatus());
        serviceOrder.setLastUpdated(new Date());
        return ServiceOrderMapper.buildResponse(serviceOrderRepository.save(serviceOrder));
    }
}
