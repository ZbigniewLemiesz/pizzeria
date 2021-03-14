package com.example.pizzeria.order;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findOrderById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        return order;
    }

    public Order saveOrder(Order order){
        orderRepository.save(order);
        return order;
    }


    public void update(Order order) {
        orderRepository.save(order);
    }
}
