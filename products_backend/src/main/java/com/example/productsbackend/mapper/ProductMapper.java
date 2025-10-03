package com.example.productsbackend.mapper;

import java.util.List;

import com.example.productsbackend.dto.ProductRequest;
import com.example.productsbackend.dto.ProductResponse;
import com.example.productsbackend.model.Product;

/**
 * Mapper utility for converting between Product entity and DTOs.
 */
public final class ProductMapper {

    private ProductMapper() {
        // Utility class
    }

    // PUBLIC_INTERFACE
    /**
     * Convert Product entity to ProductResponse DTO.
     */
    public static ProductResponse toResponse(Product product) {
        if (product == null) return null;
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantity()
        );
    }

    // PUBLIC_INTERFACE
    /**
     * Convert list of Product entities to list of ProductResponse DTOs.
     */
    public static List<ProductResponse> toResponseList(List<Product> products) {
        return products.stream().map(ProductMapper::toResponse).toList();
    }

    // PUBLIC_INTERFACE
    /**
     * Apply ProductRequest fields to an existing Product entity.
     */
    public static void applyRequest(ProductRequest request, Product product) {
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
    }
}
