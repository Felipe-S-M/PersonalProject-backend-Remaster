package com.fixingsolutions.customer.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
}
