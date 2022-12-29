package com.fixingsolutions.authority.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAuthorityRequest {
    @NotNull(message = "Invalid role")
    @NotBlank(message = "Invalid role")
    private String role;
    @NotNull
    private Integer id;
}
