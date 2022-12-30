package com.fixingsolutions.customer.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequest {
    @NotNull(message = "Id cannot be null")
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotNull(message = "Cpf cannot be null")
    private String cpf;
    @NotNull(message = "Phone cannot be null")
    private String phone;
}
