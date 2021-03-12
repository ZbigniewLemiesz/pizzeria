package com.example.pizzeria.order;

import com.example.pizzeria.product.Product;
import lombok.Data;

@Data
public class CartItemDTO {
    private Product product;
    private Integer quantity;
    private Order order;

    public CartItemDTO() {
    }

    public CartItemDTO(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
