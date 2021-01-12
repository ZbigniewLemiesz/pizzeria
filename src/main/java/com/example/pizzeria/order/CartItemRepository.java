package com.example.pizzeria.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,CartItemKey> {
}
