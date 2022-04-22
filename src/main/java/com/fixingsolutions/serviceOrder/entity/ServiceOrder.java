package com.fixingsolutions.serviceOrder.entity;

import com.fixingsolutions.budget.entity.Budget;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ServiceOrder {
    @Id
    private Integer id;
    @Version
    private Integer version;

    @ManyToOne
    private Budget budget;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String name;
    private Date startedAt;
    private Date lastUpdated;
}
