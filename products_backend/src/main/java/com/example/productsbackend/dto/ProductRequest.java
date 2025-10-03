package com.example.productsbackend.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO representing the incoming payload for creating or updating a Product.
 */
@Schema(name = "ProductRequest", description = "Incoming product data for create/update operations")
public class ProductRequest {

    @Schema(description = "Product name", example = "Wireless Mouse")
    @NotBlank(message = "Product name is required")
    @Size(max = 255, message = "Product name must be at most 255 characters")
    private String name;

    @Schema(description = "Product price (non-negative)", example = "29.99")
    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be non-negative")
    private BigDecimal price;

    @Schema(description = "Available quantity (non-negative integer)", example = "100")
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be non-negative")
    private Integer quantity;

    public ProductRequest() {}

    public ProductRequest(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
