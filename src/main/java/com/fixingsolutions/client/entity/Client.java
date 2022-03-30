package com.fixingsolutions.client.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Client {
    @Id
    private Long id;
    @Version
    private Integer version;

    private String name;
    private String email;
    private String cpf;
    private String phone;
}
