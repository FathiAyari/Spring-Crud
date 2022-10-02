package com.example.takwa.services;

import com.example.takwa.dto.ProductDto;
import com.example.takwa.dto_convertor.ProductDtoConvertor;
import com.example.takwa.entities.Category;
import com.example.takwa.entities.Product;
import com.example.takwa.enumerate.Results;
import com.example.takwa.repositories.CategoryRepository;
import com.example.takwa.repositories.ProductsRepository;
import com.example.takwa.responses.CrudResponse;
import org.springframework.stereotype.Service;
import requests.ProductRequest;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    private final ProductsRepository productsRepository;
    private  final CategoryRepository categoryRepository;

    public ProductServices(ProductsRepository productsRepository, CategoryRepository categoryRepository) {
        this.productsRepository = productsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDto> getProducts(){
        List<Product> products = productsRepository.findAll();
        return products.stream().map(ProductDtoConvertor::productToDto).toList();
    }

    public CrudResponse createProduct(ProductRequest productRequest){
        Product product=new Product();
        product.setName(productRequest.getName());
        product.setBar_code(productRequest.getBar_code());
        product.setRate(productRequest.getRate());
        product.setPrice(productRequest.getPrice());
        Category category=categoryRepository.getById(productRequest.getCategory_id());
        product.setCategory(category);
        // we use save in orderto save an object in data base
        productsRepository.save(product);

        return new CrudResponse(Results.SUCCESSFULLY);
    }
    public CrudResponse deleteProduct(Long id){
        // verify the product is present
        Optional<Product> product=productsRepository.findById(id);
        if(product.isPresent()){
            // we use delete in orderto delete an object in data base
            productsRepository.deleteById(id);
            return new CrudResponse(Results.SUCCESSFULLY);
        }

        return new CrudResponse(Results.ProductUnfound);

    }


    public CrudResponse updateProduct(Long id,ProductRequest productRequest){
        Product product=productsRepository.getById(id);
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setRate(productRequest.getRate());
        product.setBar_code(productRequest.getBar_code());
        productsRepository.save(product);

        return new CrudResponse(Results.SUCCESSFULLY);

    }

}
