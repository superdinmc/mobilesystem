package com.superdinmc.mobilesystem.controller;

import com.superdinmc.mobilesystem.entity.Product;
import com.superdinmc.mobilesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save-product")
    public String saveProduct(Product product, Model model, BindingResult bindingResult) {
        productService.createProduct(product);
        model.addAttribute("product", product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String ListProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list-product";
    }

    @GetMapping("/add-product")
    public String addProduct(Product product, Model model) {
        model.addAttribute("product", product);
        return "add-product";
    }
}
