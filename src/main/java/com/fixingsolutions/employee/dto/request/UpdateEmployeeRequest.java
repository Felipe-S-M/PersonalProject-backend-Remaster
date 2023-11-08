package com.fixingsolutions.employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
public class UpdateEmployeeRequest {
    @NotNull
    private Integer id;
    @NotNull
    @NotBlank
    private String username, password, name;

    @NotEmpty
    private List<Integer> authoritiesIds;
}
