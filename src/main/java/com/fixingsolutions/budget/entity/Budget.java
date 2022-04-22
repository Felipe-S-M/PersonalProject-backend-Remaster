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
    @JoinColumn(name="client_id")
    private Client client;
}
