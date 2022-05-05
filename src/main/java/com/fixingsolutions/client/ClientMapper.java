package com.fixingsolutions.client;

import com.fixingsolutions.client.dtos.response.ClientResponse;
import com.fixingsolutions.client.entity.Client;

public class ClientMapper {
    public static Client buildClient(Integer id, String name, String email, String cpf, String phone) {
        return Client.builder()
                .id(id)
                .cpf(cpf)
                .email(email)
                .name(name)
                .phone(phone)
                .build();
    }

    public static ClientResponse buildClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .cpf(client.getCpf())
                .email(client.getEmail())
                .name(client.getName())
                .phone(client.getPhone())
                .build();
    }
}
