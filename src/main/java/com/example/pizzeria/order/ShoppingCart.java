package com.example.pizzeria.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {

    private List<CartItemDTO> cartItemDTOS = new ArrayList<>();

    public ShoppingCart() {
    }

    BigDecimal getTotalPrice() {
        BigDecimal total  = BigDecimal.valueOf(0);
        for (CartItemDTO i : cartItemDTOS) {
            BigDecimal iPrice  = i.getProduct().getPrice();
            iPrice = iPrice.multiply(BigDecimal.valueOf(i.getQuantity()));
            total = total.add(iPrice);
        }
        return total;
    }

    void addCartItem(CartItemDTO cartItem) {
        this.cartItemDTOS.add(cartItem);

    }

}
