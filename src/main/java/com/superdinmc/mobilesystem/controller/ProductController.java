package com.superdinmc.mobilesystem.controller;

import com.superdinmc.mobilesystem.entity.Product;
import com.superdinmc.mobilesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/apply-product")
    public String applyProduct(Product product, Model model, BindingResult bindingResult) {
        productService.updateProduct(product);
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

    @GetMapping("/edit-product/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @GetMapping("/remove-product/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productService.deleteProduct(id);
        //model.addAttribute("products", productService.findAll());
        return "redirect:/products";
    }
}
