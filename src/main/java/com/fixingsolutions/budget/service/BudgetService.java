package com.fixingsolutions.budget.service;

import com.fixingsolutions.budget.BudgetMapper;
import com.fixingsolutions.budget.dtos.request.CreateBudgetRequest;
import com.fixingsolutions.budget.dtos.request.UpdateBudgetRequest;
import com.fixingsolutions.budget.dtos.response.BudgetResponse;
import com.fixingsolutions.budget.repository.BudgetRepository;
import com.fixingsolutions.customer.service.CustomerService;
import com.fixingsolutions.employee.service.EmployeeService;
import com.fixingsolutions.serviceType.entity.ServiceType;
import com.fixingsolutions.serviceType.service.ServiceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BudgetService {
    private BudgetRepository budgetRepository;
    private EmployeeService employeeService;
    private CustomerService customerService;
    private ServiceTypeService serviceTypeService;

    public List<BudgetResponse> findAll() {
        return budgetRepository.findAll().stream().map(BudgetMapper::buildBudgetResponse).collect(Collectors.toList());
    }

    public BudgetResponse create(CreateBudgetRequest request, String authToken) throws Exception {
        var employee = employeeService.getEmployeeFromToken(authToken);
        var customer = customerService.findById(request.getCustomerId());
        var serviceTypes = buildServiceTypes(request.getServicesTypesIds());
        var value = serviceTypes.stream().map(ServiceType::getValue).reduce(BigDecimal.ZERO,BigDecimal::add);
        var budget = BudgetMapper.buildBudget(
                null, value, request.getExpectedHours(), request.getIsApproved(), employee, customer);
        budget.setServiceTypes(serviceTypes);
        return BudgetMapper.buildBudgetResponse(budgetRepository.save(budget));
    }

    public List<ServiceType> buildServiceTypes(List<Integer> serviceTypeIds) throws Exception {
        var serviceTypes = new ArrayList<ServiceType>();
        for (Integer id : serviceTypeIds) {
            serviceTypes.add(serviceTypeService.findById(id));
        }
        return serviceTypes;
    }

    public BudgetResponse update(UpdateBudgetRequest request) throws Exception {
        var budget = budgetRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        var customer = customerService.findById(request.getCustomerId());
        var serviceTypes = buildServiceTypes(request.getServicesTypesIds());
        var value = serviceTypes.stream().map(ServiceType::getValue).reduce(BigDecimal.ZERO,BigDecimal::add);
        budget.setServiceTypes(serviceTypes);
        budget.setValue(value);
        budget.setExpectedHours(request.getExpectedHours());
        budget.setApproved(request.getIsApproved());
        budget.setCustomer(customer);
        budget.setServiceTypes(serviceTypes);
        return BudgetMapper.buildBudgetResponse(budgetRepository.save(budget));
    }

    public void delete(Integer id) {
        var budget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        budgetRepository.delete(budget);
    }
}
