package com.example.productsbackend.service;

import java.util.List;

import com.example.productsbackend.dto.ProductRequest;
import com.example.productsbackend.dto.ProductResponse;

/**
 * Product service defines the business operations for managing products.
 */
public interface ProductService {

    // PUBLIC_INTERFACE
    ProductResponse create(ProductRequest request);

    // PUBLIC_INTERFACE
    List<ProductResponse> findAll();

    // PUBLIC_INTERFACE
    ProductResponse findById(Long id);

    // PUBLIC_INTERFACE
    ProductResponse update(Long id, ProductRequest request);

    // PUBLIC_INTERFACE
    void delete(Long id);
}
