package com.example.productsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productsbackend.model.Product;

/**
 * Repository for Product persistence operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods can be added here if needed.
}
