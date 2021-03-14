package com.example.pizzeria.order;
import com.example.pizzeria.client.Client;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @Column(name="created_at")
    private Date createdAt;


    @OneToMany(targetEntity=CartItem.class, mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items = new ArrayList<>();

    @ManyToOne
    private Client client;



    @PrePersist
    void createdAt() {
        this.createdAt = new Date() ;
    }

    public Order() {
    }
}
