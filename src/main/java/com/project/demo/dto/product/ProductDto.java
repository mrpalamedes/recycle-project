package com.project.demo.dto.product;

import com.project.demo.entity.Product;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;

    private String name;

    private String imageUrl;

    private double price;

    private String description;

    private Integer categoryId;

    public ProductDto(Product product){
        this.setId(product.getId());
        this.setName(product.getName());
        this.setImageUrl(product.getImageUrl());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setCategoryId(product.getCategory().getId());
    }

    public ProductDto(String name, String imageUrl, double price, String description, Integer categoryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDto() {
    }

    
}
