package com.example.productsbackend.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO representing the outgoing product data in API responses.
 */
@Schema(name = "ProductResponse", description = "Outgoing product data returned by the API")
public class ProductResponse {

    @Schema(description = "Unique identifier", example = "1")
    private Long id;

    @Schema(description = "Product name", example = "Wireless Mouse")
    private String name;

    @Schema(description = "Product price", example = "29.99")
    private BigDecimal price;

    @Schema(description = "Available quantity", example = "100")
    private Integer quantity;

    public ProductResponse() {}

    public ProductResponse(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

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
