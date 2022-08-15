package com.fixingsolutions.serviceType.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {
    @Id
    private Long id;

    @Version
    private Integer version;

    private String description;

    @Column(name = "service_value")
    private BigDecimal value;
}
