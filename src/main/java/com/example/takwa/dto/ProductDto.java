package com.example.takwa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
private String name;
private Long price;
private Long rate;
private String category;
}

