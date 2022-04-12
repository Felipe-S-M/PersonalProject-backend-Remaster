package com.fixingsolutions.serviceOrder.entity;

import com.fixingsolutions.budget.entity.Budget;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ServiceOrder {
    @Id
    private Long id;
    @Version
    private Integer version;

    @ManyToOne
    @JoinTable(
            name = "budget",
            joinColumns = @JoinColumn(name = "id"))
    private Budget budget;

    private Status status;
    private String name;
    private Date startedAt;
    private Date lastUpdated;
}
