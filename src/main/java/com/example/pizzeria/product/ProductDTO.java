package com.example.pizzeria.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    public ProductDTO(Long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static ProductDTO makeProductDTOFromProduct(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }



}
