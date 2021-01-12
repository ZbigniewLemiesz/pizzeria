package com.example.pizzeria.order;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order updateOrderFromShoppingCart(ShoppingCart shoppingCart,Order order){
        order.setStatus("new");
        order.setCarts(shoppingCart.getCartItems());
        return order;
    }

    public void save(Order order){
        orderRepository.save(order);
    }

    public Order saveNewOrder(){
        Order order = new Order();
        orderRepository.save(order);
        return order;
    }
















}
