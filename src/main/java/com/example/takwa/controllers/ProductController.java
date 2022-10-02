package com.example.takwa.controllers;

import com.example.takwa.dto.ProductDto;
import com.example.takwa.entities.Product;
import com.example.takwa.responses.CrudResponse;
import com.example.takwa.services.ProductServices;
import org.springframework.web.bind.annotation.*;
import requests.ProductRequest;

import java.util.List;

@RestController
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productServices.getProducts();
    }

    @PostMapping("/create_product")
    public CrudResponse createProducts(@RequestBody ProductRequest product) {
        return productServices.createProduct(product);
    }
    @DeleteMapping("/product/{id}")
    public CrudResponse deleteProduct(@PathVariable Long id) {
        return productServices.deleteProduct(id);
    }

    @PutMapping("/product/{id}")
    public CrudResponse updateProduct(@PathVariable Long id,@RequestBody ProductRequest productRequest) {
        return productServices.updateProduct(id,productRequest);
    }
}
