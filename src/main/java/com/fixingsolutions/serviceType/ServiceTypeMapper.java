package com.fixingsolutions.serviceType;

import com.fixingsolutions.serviceType.dto.response.ServiceTypeResponse;
import com.fixingsolutions.serviceType.entity.ServiceType;

import java.math.BigDecimal;

public class ServiceTypeMapper {
    public static ServiceType buildNewServiceType(String descritpion, BigDecimal value) {
        return ServiceType.builder()
                .description(descritpion)
                .value(value)
                .build();
    }

    public static ServiceTypeResponse serviceTypeResponse(ServiceType serviceType) {
        return ServiceTypeResponse.builder()
                .description(serviceType.getDescription())
                .value(serviceType.getValue())
                .build();
    }
}
