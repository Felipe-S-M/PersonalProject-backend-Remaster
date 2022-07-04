package com.fixingsolutions.budget;

import com.fixingsolutions.budget.dtos.response.BudgetResponse;
import com.fixingsolutions.budget.dtos.response.CustomerResponse;
import com.fixingsolutions.budget.dtos.response.EmployeeResponse;
import com.fixingsolutions.budget.entity.Budget;
import com.fixingsolutions.customer.entity.Customer;
import com.fixingsolutions.employee.entity.Employee;

import java.math.BigDecimal;

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
        return BudgetResponse.builder()
                .id(budget.getId())
                .customer(buildCustomerResponse(budget.getCustomer()))
                .createdBy(buildEmployeeResponse(budget.getCreatedBy()))
                .approved(budget.getApproved())
                .expectedHours(budget.getExpectedHours())
                .value(budget.getValue())
                .build();
    }

    public static CustomerResponse buildCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .email(customer.getEmail())
                .id(customer.getId())
                .build();
    }

    public static EmployeeResponse buildEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .build();
    }
}
