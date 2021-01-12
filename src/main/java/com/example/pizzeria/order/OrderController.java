package com.example.pizzeria.order;

import com.example.pizzeria.product.Product;
import com.example.pizzeria.product.ProductDTO;
import com.example.pizzeria.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class OrderController {

    private ProductService productService;
    private OrderService orderService;
    private CartItemService cartItemService;
    private ShoppingCart shoppingCart = new ShoppingCart();

    @Autowired
    public OrderController(ProductService productService, OrderService orderService, CartItemService cartItemService) {
        this.productService = productService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
    }


    @GetMapping("/order")
    public String
    displayItems(Model model) {
        List<ProductDTO> itemList = productService.findProducts();
        model.addAttribute("itemList", itemList);
        return "ItemForm";
    }

    @GetMapping("/order/addItems")
    public String addItemsToThaCart(@RequestParam Integer quantity,
                                    @RequestParam Long productId) {
        Product product = productService.getProduct(productId);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        shoppingCart.addCartItem(cartItem);
        //------------------------------------
        System.out.println(shoppingCart.getCartItems().toString());
        System.out.println("--------------------" + shoppingCart.getTotalPrice().toString());
        return "redirect:/order";
    }

    @GetMapping("/order/place")
    public String placeOrder() {
        Order order = orderService.saveNewOrder();
        orderService.updateOrderFromShoppingCart(shoppingCart, order);
        cartItemService.saveCartItemsFromOrder(order);
        orderService.save(order);

        return "HomePage";
    }


}
