package com.fixingsolutions.employee.dto.response;

import com.fixingsolutions.authority.entity.Authority;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EmployeeResponse {
    private Integer id;
    private String username;
    private String name;
    private List<Authority> authorities;
}
