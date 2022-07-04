package com.fixingsolutions.budget.service;

import com.fixingsolutions.budget.BudgetMapper;
import com.fixingsolutions.budget.dtos.request.CreateBudgetRequest;
import com.fixingsolutions.budget.dtos.request.UpdateBudgetRequest;
import com.fixingsolutions.budget.dtos.response.BudgetResponse;
import com.fixingsolutions.budget.repository.BudgetRepository;
import com.fixingsolutions.customer.service.CustomerService;
import com.fixingsolutions.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BudgetService {
    private BudgetRepository budgetRepository;
    private EmployeeService employeeService;
    private CustomerService customerService;

    public List<BudgetResponse> findAll() {
        return budgetRepository.findAll().stream().map(BudgetMapper::buildBudgetResponse).collect(Collectors.toList());
    }

    public BudgetResponse create(CreateBudgetRequest request, String authToken) {
        var employee = employeeService.getEmployeeFromToken(authToken);
        var customer = customerService.findById(request.getCustomerId());
        var budget = BudgetMapper.buildBudget(
                null, request.getValue(), request.getExpectedHours(), request.getApproved(), employee, customer);
        return BudgetMapper.buildBudgetResponse(budgetRepository.save(budget));
    }

    public BudgetResponse update(UpdateBudgetRequest request) {
        var budget = budgetRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        var customer = customerService.findById(request.getCustomerId());
        budget.setValue(request.getValue());
        budget.setExpectedHours(request.getExpectedHours());
        budget.setApproved(request.getApproved());
        budget.setCustomer(customer);
        return BudgetMapper.buildBudgetResponse(budgetRepository.save(budget));
    }

    public void delete(Long id) {
        var budget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        budgetRepository.delete(budget);
    }
}
