package com.example.pizzeria.order;

import com.example.pizzeria.product.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();

    public ShoppingCart() {
    }

    BigDecimal getTotalPrice() {
        BigDecimal total  = BigDecimal.valueOf(0);
        for (CartItem i : cartItems) {
            BigDecimal iPrice  = i.getProduct().getPrice();
            iPrice = iPrice.multiply(BigDecimal.valueOf(i.getQuantity()));
            total = total.add(iPrice);
        }
        return total;
    }

    void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);

    }

}
