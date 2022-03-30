package com.fixingsolutions.serviceOrder.entity;

import com.fixingsolutions.budget.entity.Budget;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.util.Date;

@Entity
public class ServiceOrder {
    @Id
    private Long id;
    @Version
    private Integer version;

    @ManyToOne
    private Budget budget;

    private Status status;
    private String name;
    private Date startedAt;
    private Date lastUpdated;
}
