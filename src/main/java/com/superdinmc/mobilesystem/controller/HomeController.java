package com.superdinmc.mobilesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/AllProducts")
    public String AllProduct() {
        return "all-products";
    }

    @GetMapping("/bestseller")
    public String BestSeller() {
        return "bestseller";
    }

    @GetMapping("/newproduct")
    public String NewProduct() {
        return "newproduct";
    }

//    @GetMapping("/404")
//    public String notFound() {
//        return "forward:/error";
//    }
}
