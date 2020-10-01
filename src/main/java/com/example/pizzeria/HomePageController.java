package com.example.pizzeria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/order")
    public String chooseProducts(){
        return "ProductForm";
    }

}
