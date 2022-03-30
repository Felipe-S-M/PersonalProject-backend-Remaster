package com.fixingsolutions.serviceType.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
public class ServiceType {
    @Id
    private Long id;

    @Version
    private Integer version;

    private String description;
    private BigDecimal value;
}
