package com.example.productsbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productsbackend.dto.ProductRequest;
import com.example.productsbackend.dto.ProductResponse;
import com.example.productsbackend.exception.NotFoundException;
import com.example.productsbackend.mapper.ProductMapper;
import com.example.productsbackend.model.Product;
import com.example.productsbackend.repository.ProductRepository;
import com.example.productsbackend.service.ProductService;

/**
 * Implementation of ProductService responsible for Product business logic.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    @Override
    public ProductResponse create(ProductRequest request) {
        Product entity = new Product();
        ProductMapper.applyRequest(request, entity);
        Product saved = repository.save(entity);
        return ProductMapper.toResponse(saved);
    }

    // PUBLIC_INTERFACE
    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        return ProductMapper.toResponseList(repository.findAll());
    }

    // PUBLIC_INTERFACE
    @Override
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        Product product = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return ProductMapper.toResponse(product);
    }

    // PUBLIC_INTERFACE
    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        ProductMapper.applyRequest(request, product);
        Product saved = repository.save(product);
        return ProductMapper.toResponse(saved);
    }

    // PUBLIC_INTERFACE
    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
