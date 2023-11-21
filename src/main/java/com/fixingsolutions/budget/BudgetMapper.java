package com.fixingsolutions.budget;

import com.fixingsolutions.budget.dtos.response.BudgetResponse;
import com.fixingsolutions.budget.entity.Budget;
import com.fixingsolutions.customer.dtos.response.CustomerResponse;
import com.fixingsolutions.customer.entity.Customer;
import com.fixingsolutions.employee.dto.response.EmployeeResponse;
import com.fixingsolutions.employee.entity.Employee;
import com.fixingsolutions.serviceType.dto.response.ServiceTypeResponse;
import com.fixingsolutions.serviceType.entity.ServiceType;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class BudgetMapper {

    public static Budget buildBudget(
            Integer id,
            BigDecimal value,
            Integer expectedHours,
            Boolean approved,
            Employee employee,
            Customer customer
    ) {
        return Budget.builder()
                .id(id)
                .value(value)
                .expectedHours(expectedHours)
                .approved(approved)
                .createdBy(employee)
                .customer(customer)
                .build();
    }

    public static BudgetResponse buildBudgetResponse(Budget budget) {
        var serviceTypes = budget.getServiceTypes().stream()
                .map(BudgetMapper::buildServiceTypeResponse)
                .collect(Collectors.toList());
        return BudgetResponse.builder()
                .id(budget.getId())
                .customer(buildCustomerResponse(budget.getCustomer()))
                .createdBy(buildEmployeeResponse(budget.getCreatedBy()))
                .approved(budget.getApproved())
                .expectedHours(budget.getExpectedHours())
                .value(budget.getValue())
                .services(serviceTypes)
                .build();
    }

    public static CustomerResponse buildCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .email(customer.getEmail())
                .cpf(customer.getCpf())
                .name(customer.getName())
                .phone(customer.getPhone())
                .id(customer.getId())
                .build();
    }

    public static ServiceTypeResponse buildServiceTypeResponse(ServiceType serviceType) {
        return ServiceTypeResponse.builder()
                .value(serviceType.getValue())
                .description(serviceType.getDescription())
                .build();
    }

    public static EmployeeResponse buildEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .authorities(employee.getAuthorities())
                .username(employee.getUsername())
                .build();
    }
}
