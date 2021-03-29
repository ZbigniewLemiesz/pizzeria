package com.example.pizzeria.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
public class ShoppingCart {

    private Set<CartItemDTO> cartItemDTOs;

    public ShoppingCart() {
        cartItemDTOs= new HashSet<>();
    }

    public ShoppingCart(Set<CartItemDTO> cartItemDTOs) {
        this.cartItemDTOs = cartItemDTOs;
    }

    BigDecimal getTotalPrice() {
        BigDecimal total  = BigDecimal.valueOf(0);
        for (CartItemDTO i : cartItemDTOs) {
            BigDecimal iPrice  = i.getProduct().getPrice();
            iPrice = iPrice.multiply(BigDecimal.valueOf(i.getQuantity()));
            total = total.add(iPrice);
        }
        return total;
    }

    void addCartItem(CartItemDTO cartItem) {
        this.cartItemDTOs.add(cartItem);
    }

    public void clear() {
        this.cartItemDTOs.clear();
    }
}

