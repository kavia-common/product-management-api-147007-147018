package com.example.productsbackend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.productsbackend.dto.ProductRequest;
import com.example.productsbackend.dto.ProductResponse;
import com.example.productsbackend.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * REST controller for managing products.
 * Base path: /api/v1/products
 */
@RestController
@RequestMapping("/api/v1/products")
@Validated
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // PUBLIC_INTERFACE
    @Operation(
        summary = "Create a product",
        description = "Creates a new product with the given name, price, and quantity.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Product created",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
        }
    )
    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        ProductResponse created = service.create(request);
        return ResponseEntity
            .created(URI.create("/api/v1/products/" + created.getId()))
            .body(created);
    }

    // PUBLIC_INTERFACE
    @Operation(
        summary = "List products",
        description = "Returns all products.",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                content = @Content(schema = @Schema(implementation = ProductResponse.class)))
        }
    )
    @GetMapping
    public ResponseEntity<List<ProductResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    // PUBLIC_INTERFACE
    @Operation(
        summary = "Get product by id",
        description = "Returns a single product by its id.",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // PUBLIC_INTERFACE
    @Operation(
        summary = "Update product",
        description = "Updates an existing product by id.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Updated",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // PUBLIC_INTERFACE
    @Operation(
        summary = "Delete product",
        description = "Deletes a product by id.",
        responses = {
            @ApiResponse(responseCode = "204", description = "Deleted"),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
