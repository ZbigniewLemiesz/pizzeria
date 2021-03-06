package com.example.pizzeria.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@RequiredArgsConstructor
public class CartItemKey implements Serializable {

    @Column(name = "product_id")
    Long productID;

    @Column(name = "order_id")
    Long orderID;


    public CartItemKey(Long productID, Long orderID) {
        this.productID = productID;
        this.orderID = orderID;
    }
}
