package com.fixingsolutions.budget.entity;

import com.fixingsolutions.client.entity.Client;
import com.fixingsolutions.employee.entity.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
public class Budget {
    @Id
    private Long id;

    @Version
    private Integer version;

    private BigDecimal value;
    private Integer expectedHours;
    private Boolean approved;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Client client;
}
