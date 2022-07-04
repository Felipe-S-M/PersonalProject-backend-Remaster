package com.fixingsolutions.customer.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequest {
    private String name;
    private String email;
    private String cpf;
    private String phone;
}
