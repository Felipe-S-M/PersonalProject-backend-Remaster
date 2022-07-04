package com.fixingsolutions.budget.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerResponse {
    private Integer id;
    private String email;
}
