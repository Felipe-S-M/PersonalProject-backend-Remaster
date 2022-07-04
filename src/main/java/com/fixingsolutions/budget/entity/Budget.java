package com.fixingsolutions.budget.entity;

import com.fixingsolutions.customer.entity.Customer;
import com.fixingsolutions.employee.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    @Id
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "total_value")
    private BigDecimal value;
    private Integer expectedHours;
    private Boolean approved;

    @ManyToOne
    @JoinColumn(name="created_by")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}
