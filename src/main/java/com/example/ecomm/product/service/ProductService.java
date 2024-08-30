package com.example.ecomm.product.service;

import com.example.ecomm.exception.customExceptions.NotFoundException;
import com.example.ecomm.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Integer id);
    Product create(Product product);
    Product update(Product product) throws NotFoundException;
    void deleteById(Integer id);
}
