package com.example.pizzeria.order;

import lombok.Data;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Data
@Service
public class ShoppingCart {
    //private static final Singleton INSTANCE = new Singleton();

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
        for (CartItemDTO e:cartItemDTOs) {
            if(cartItem.equals(e)){
                e.setQuantity(cartItem.getQuantity()+e.getQuantity());
            }
        }
        this.cartItemDTOs.add(cartItem);
    }

    void updateCartItem(CartItemDTO cartItem) {
        for (CartItemDTO e:cartItemDTOs) {
            if(cartItem.equals(e)){
                if(cartItem.getQuantity()>0){
                    e.setQuantity(cartItem.getQuantity());
                }else{
                    this.cartItemDTOs.remove(e);
                    break;
                }
            }
        }
    }

    public void clear() {
        this.cartItemDTOs.clear();
    }
}

