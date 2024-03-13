package com.superdinmc.mobilesystem.service;

import com.superdinmc.mobilesystem.entity.Product;
import com.superdinmc.mobilesystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        return product;
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        productRepository.deleteById(product.id);
    }

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
//            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }
}
