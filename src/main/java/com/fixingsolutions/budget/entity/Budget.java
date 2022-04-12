package com.fixingsolutions.budget.entity;

import com.fixingsolutions.client.entity.Client;
import com.fixingsolutions.employee.entity.Employee;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Budget {
    @Id
    private Long id;

    @Version
    private Integer version;

    @Column(name = "total_value")
    private BigDecimal value;
    private Integer expectedHours;
    private Boolean approved;

    @ManyToOne
    @JoinTable(
            name = "employee",
            joinColumns = @JoinColumn(name = "id"))
    private Employee createdBy;

    @ManyToOne
    private Client client;
}
