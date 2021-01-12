package com.example.pizzeria.order;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CartItemService {

    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void saveCartItemsFromOrder(Order order){
        for (CartItem i : order.getCarts()) {
            CartItemKey cartItemKey = new CartItemKey(i.getProduct().getId(), i.getOrder().getId());
            CartItem cartItem = new CartItem(cartItemKey,i.getQuantity(), i.getProduct(), i.getOrder());
            cartItemRepository.save(cartItem);
        }
    }

}
