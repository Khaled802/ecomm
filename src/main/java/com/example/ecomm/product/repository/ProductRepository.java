package com.example.ecomm.product.repository;

import com.example.ecomm.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}