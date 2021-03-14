package com.example.pizzeria.order;

import com.example.pizzeria.product.Product;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;



@Getter
@Entity
@Table(name = "orders_products")
public class CartItem {

    @EmbeddedId
    private CartItemKey id;

    private Integer quantity;


    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    public CartItem() {
    }


    public CartItem(CartItemKey id, Integer quantity, Product product, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

}
