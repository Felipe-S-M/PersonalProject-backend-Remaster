package com.fixingsolutions;

import com.fixingsolutions.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication(scanBasePackages = "com.fixingsolutions")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class FixingSolutionsApplication extends SpringBootServletInitializer implements CommandLineRunner{

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(FixingSolutionsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        service.createDefaultAdminUser();
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FixingSolutionsApplication.class);
    }
}
