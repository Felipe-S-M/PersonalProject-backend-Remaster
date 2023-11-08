package com.fixingsolutions.employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeRequest {
    @NotNull(message = "Username cannot be null")
    private String username;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "Authorities cannot be empty")
    private List<Integer> authoritiesIds;
}
