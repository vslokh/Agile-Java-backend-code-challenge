package com.optimalVirtualEmployee.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OpenAPIDefinition(info = @Info(title = "Optimal Virtual Employee - User Management APIs", version = "1.0", description = "API for Managing Optimal Virtual Employee Pvt. Ltd. Users"))
@SpringBootApplication
public class UserManagementApplication {
    private static final Logger logger = LoggerFactory.getLogger(UserManagementApplication.class);

    public static void main(String[] args) {
        logger.info("Starting User Management Application");
        SpringApplication.run(UserManagementApplication.class, args);
        logger.info("User Management Application started successfully");
    }
}