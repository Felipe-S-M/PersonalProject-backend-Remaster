package com.fixingsolutions.client.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
@Data
public class Client {
    @Id
    private Integer id;
    @Version
    private Integer version;

    private String name;
    private String email;
    private String cpf;
    private String phone;
}
