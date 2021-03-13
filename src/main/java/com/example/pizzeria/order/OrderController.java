package com.example.pizzeria.order;
import com.example.pizzeria.client.ClientService;
import com.example.pizzeria.product.Product;
import com.example.pizzeria.product.ProductDTO;
import com.example.pizzeria.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class OrderController {

    private ProductService productService;
    private OrderService orderService;
    private CartItemService cartItemService;
    private ClientService clientService;
    private ShoppingCart shoppingCart;

    @Autowired
    public OrderController(ProductService productService, OrderService orderService, CartItemService cartItemService,ClientService clientService) {
        this.productService = productService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
        this.clientService = clientService;
    }


    @GetMapping("/order")
    public String displayItems(Model model) {
        List<ProductDTO> itemList = productService.findProducts();
        model.addAttribute("itemList", itemList);
        return "ItemForm";
    }

    @GetMapping("/order/addItems")
    public String addItemsToThaCart(@RequestParam Integer quantity,
                                    @RequestParam Long productId) {
        Product product = productService.getProduct(productId);
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setProduct(product);
        cartItemDTO.setQuantity(quantity);
        if(shoppingCart==null){
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.addCartItem(cartItemDTO);
        return "redirect:/order";
    }

    @GetMapping("/order/cart")
    public String showCart(Model model) {
        List<CartItemDTO> cartItemDTOS = shoppingCart.getCartItemDTOs();
        model.addAttribute("itemList", cartItemDTOS);
        BigDecimal totalPrice = shoppingCart.getTotalPrice();
        model.addAttribute("totalPrice",totalPrice);
        return "ShoppingCart";
    }

    @PostMapping ("/order/order")
    public String processOrder(SessionStatus sessionStatus) {
        Order order = new Order();
        order.setCreatedAt(new Date());
        order.setStatus("new");
        order.setClient(clientService.getClient(3L));
        order.setItems(new ArrayList<>());
        orderService.saveOrder(order);
        List<CartItem> items = new ArrayList<>();

        for (CartItemDTO i: shoppingCart.getCartItemDTOs()) {
            i.setOrder(order);
            CartItem cartItem = cartItemService.getCartItemFromDTO(i);
            items.add(cartItem);
            cartItemService.save(cartItem);
        }
        order.setItems(items);
        orderService.update(order);
        //sessionStatus.setComplete();

        return "OrderSummary";
    }


}
