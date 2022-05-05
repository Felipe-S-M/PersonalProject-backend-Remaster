package com.fixingsolutions.employee.dto.request;

import com.fixingsolutions.authority.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeRequest {
    @NotNull(message = "Username invalid")
    @NotBlank(message = "Username invalid")
    private String username;
    @NotNull(message = "Password invalid")
    @NotBlank(message = "Password invalid")
    private String password;
    @NotNull(message = "Name invalid")
    @NotBlank(message = "Name invalid")
    private String name;

    @NotEmpty(message = "Authorities can not be empty")
    private List<Authority> authorities;
}
