package com.fixingsolutions.customer;

import com.fixingsolutions.customer.dtos.response.CustomerResponse;
import com.fixingsolutions.customer.entity.Customer;

public class CustomerMapper {
    public static Customer buildCustomer(Integer id, String name, String email, String cpf, String phone) {
        return Customer.builder()
                .id(id)
                .cpf(cpf)
                .email(email)
                .name(name)
                .phone(phone)
                .build();
    }

    public static CustomerResponse buildCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .cpf(customer.getCpf())
                .email(customer.getEmail())
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();
    }
}
