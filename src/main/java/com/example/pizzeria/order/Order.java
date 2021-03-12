package com.example.pizzeria.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private LocalDateTime createdAt;


    @OneToMany(targetEntity=CartItem.class, mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items = new ArrayList<>();


//    @PrePersist
//    void createdAt() {
//        this.createdAt = LocalDateTime.now();
//    }

    public Order() {
    }
}
