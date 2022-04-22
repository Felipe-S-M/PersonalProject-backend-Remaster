package com.fixingsolutions.serviceType.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
@Data
public class ServiceType {
    @Id
    private Integer id;

    @Version
    private Integer version;

    private String description;

    @Column(name = "service_value")
    private BigDecimal value;
}
