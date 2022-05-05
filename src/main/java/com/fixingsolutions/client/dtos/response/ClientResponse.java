package com.fixingsolutions.client.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientResponse {
    private Integer id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
}
