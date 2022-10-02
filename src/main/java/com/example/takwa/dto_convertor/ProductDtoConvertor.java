package com.example.takwa.dto_convertor;

import com.example.takwa.dto.ProductDto;
import com.example.takwa.entities.Product;

public class ProductDtoConvertor {
     public static ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory().getName());
        productDto.setName(product.getName());
        productDto.setRate(product.getRate());

        return productDto;
    }
}
