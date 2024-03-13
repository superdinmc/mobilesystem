package com.superdinmc.mobilesystem.repository;

import com.superdinmc.mobilesystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
