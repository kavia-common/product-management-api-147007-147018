package com.example.productsbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * Product entity mapped to the database.
 * Represents a product with name, price, and quantity.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Size(max = 255, message = "Product name must be at most 255 characters")
    @Column(nullable = false, length = 255)
    private String name;

    @Min(value = 0, message = "Price must be non-negative")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Min(value = 0, message = "Quantity must be non-negative")
    @Column(nullable = false)
    private Integer quantity;

    public Product() {}

    public Product(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    // PUBLIC_INTERFACE
    public Long getId() {
        return id;
    }

    // PUBLIC_INTERFACE
    public void setId(Long id) {
        this.id = id;
    }

    // PUBLIC_INTERFACE
    public String getName() {
        return name;
    }

    // PUBLIC_INTERFACE
    public void setName(String name) {
        this.name = name;
    }

    // PUBLIC_INTERFACE
    public BigDecimal getPrice() {
        return price;
    }

    // PUBLIC_INTERFACE
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // PUBLIC_INTERFACE
    public Integer getQuantity() {
        return quantity;
    }

    // PUBLIC_INTERFACE
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
