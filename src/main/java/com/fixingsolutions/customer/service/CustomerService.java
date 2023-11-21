package com.fixingsolutions.customer.service;

import com.fixingsolutions.customer.CustomerMapper;
import com.fixingsolutions.customer.dtos.request.CreateCustomerRequest;
import com.fixingsolutions.customer.dtos.request.UpdateCustomerRequest;
import com.fixingsolutions.customer.dtos.response.CustomerResponse;
import com.fixingsolutions.customer.entity.Customer;
import com.fixingsolutions.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public CustomerResponse createClient(CreateCustomerRequest request) {
        return CustomerMapper.buildCustomerResponse(customerRepository.save(
                CustomerMapper.buildCustomer(
                        null, request.getName(), request.getPhone(), request.getCpf(), request.getPhone())));
    }

    public CustomerResponse updateClient(UpdateCustomerRequest request) {
        var customer = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        customer.setCpf(request.getCpf());
        customer.setEmail(request.getEmail());
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        return CustomerMapper.buildCustomerResponse(customerRepository.save(customer));
    }

    public void deleteClient(Integer employeeId) {
        customerRepository.delete(customerRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Client not found")));
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
