package com.fixingsolutions.serviceOrder.entity;

import com.fixingsolutions.budget.entity.Budget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
