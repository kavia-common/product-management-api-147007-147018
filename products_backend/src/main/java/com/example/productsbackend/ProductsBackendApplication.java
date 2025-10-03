package com.example.productsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Main entry point for the Products Backend Spring Boot application.
 * Applies OpenAPI metadata and configures component scanning for the application.
 */
@OpenAPIDefinition(
    info = @Info(
        title = "Products API",
        version = "1.0.0",
        description = "A modern RESTful API for managing products with CRUD operations.",
        contact = @Contact(
            name = "Products Team",
            email = "dev@example.com"
        )
    )
)
@SpringBootApplication
public class ProductsBackendApplication {

    // PUBLIC_INTERFACE
    /**
     * Application bootstrap.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductsBackendApplication.class, args);
    }
}
