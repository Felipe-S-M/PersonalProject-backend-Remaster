package com.fixingsolutions.budget.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeResponse {
    private Integer id;
    private String username;
}
