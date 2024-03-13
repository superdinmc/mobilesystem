package com.superdinmc.mobilesystem.controller;

import com.superdinmc.mobilesystem.entity.Product;
import com.superdinmc.mobilesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String ListProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list-product";
    }
}
