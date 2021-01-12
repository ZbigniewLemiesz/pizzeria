package com.example.pizzeria.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;
    //private LocalDateTime placedAt;


    @OneToMany
    private List<CartItem> carts = new ArrayList<>();

//    @PrePersist
//    void placedAt() {
//        this.placedAt = LocalDateTime.now();
//    }

    public Order() {
    }
}
