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

    public CartItem getCartItemFromDTO(CartItemDTO cartItemDTO,Order order){
        CartItemKey cartItemKey = new CartItemKey(cartItemDTO.getProduct().getId(), order.getId());
        return new CartItem(cartItemKey,cartItemDTO.getQuantity(), cartItemDTO.getProduct(), order);
    }

    public CartItem save(CartItem cartItem){
        cartItemRepository.save(cartItem);
        return cartItem;
    }

}
