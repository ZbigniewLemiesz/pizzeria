package com.example.pizzeria.api;

import com.example.pizzeria.product.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(){
        return "HomePage";
    }

    @GetMapping("/authorization")
    public String login(){
        return "LogInForm";
    }

    @GetMapping("/register")
    public String register(){
        return "RegistrationForm";
    }

//    @GetMapping("/order")
//    public String displayItems(Model model) {
//        List<ProductDTO> itemList = productService.findProducts();
//        model.addAttribute("catsdata", itemList);
//        return "ItemForm";
//    }

}
