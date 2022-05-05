package com.fixingsolutions.client.controller;

import com.fixingsolutions.client.dtos.request.CreateClientRequest;
import com.fixingsolutions.client.dtos.request.UpdateClientRequest;
import com.fixingsolutions.client.dtos.response.ClientResponse;
import com.fixingsolutions.client.entity.Client;
import com.fixingsolutions.client.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Secured("ROLE_ADMIN")
@RequestMapping("/client")
@RestController
public class ClientController {
    private ClientService clientService;

    @GetMapping("/findAll")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/create")
    public ClientResponse create(@RequestBody CreateClientRequest request) {
        return clientService.createClient(request);
    }

    @PostMapping("/update")
    public ClientResponse update(@RequestBody UpdateClientRequest request) {
        return clientService.updateClient(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
