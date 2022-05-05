package com.fixingsolutions.client.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateClientRequest {
    private Integer id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
}
