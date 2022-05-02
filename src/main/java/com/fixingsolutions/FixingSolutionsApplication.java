package com.fixingsolutions;

import com.fixingsolutions.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@AllArgsConstructor
@SpringBootApplication(scanBasePackages = "com.fixingsolutions")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class FixingSolutionsApplication implements CommandLineRunner{

    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(FixingSolutionsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        service.createDefaultAdminUser();
    }
}
