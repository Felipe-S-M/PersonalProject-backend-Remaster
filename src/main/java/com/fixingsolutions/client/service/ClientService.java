package com.fixingsolutions.client.service;

import com.fixingsolutions.client.ClientMapper;
import com.fixingsolutions.client.dtos.request.CreateClientRequest;
import com.fixingsolutions.client.dtos.request.UpdateClientRequest;
import com.fixingsolutions.client.dtos.response.ClientResponse;
import com.fixingsolutions.client.entity.Client;
import com.fixingsolutions.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public ClientResponse createClient(CreateClientRequest request) {
        return ClientMapper.buildClientResponse(clientRepository.save(
                ClientMapper.buildClient(
                        null, request.getName(), request.getPhone(), request.getCpf(), request.getPhone())));
    }

    public ClientResponse updateClient(UpdateClientRequest request) {
        var client = clientRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setCpf(request.getCpf());
        client.setEmail(request.getEmail());
        client.setName(request.getName());
        client.setPhone(request.getPhone());
        return ClientMapper.buildClientResponse(clientRepository.save(client));
    }

    public void deleteClient(Integer employeeId) {
        clientRepository.delete(clientRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Client not found")));
    }
}
