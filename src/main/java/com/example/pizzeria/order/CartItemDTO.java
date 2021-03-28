package com.example.pizzeria.order;

import com.example.pizzeria.product.Product;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
@Getter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemDTO that = (CartItemDTO) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
