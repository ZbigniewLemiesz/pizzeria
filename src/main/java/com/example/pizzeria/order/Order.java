package com.example.pizzeria.order;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
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
    @Column(name="created_at")
    private Date createdAt;


    @OneToMany(targetEntity=CartItem.class, mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items = new ArrayList<>();


    @PrePersist
    void createdAt() {
        this.createdAt = Date.valueOf(LocalDate.now()) ;
    }

    public Order() {
    }
}
