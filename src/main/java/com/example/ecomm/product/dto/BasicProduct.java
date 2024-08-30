package com.example.ecomm.product.dto;

import com.example.ecomm.product.Product;

import java.math.BigDecimal;

public record BasicProduct(Integer id, String name, BigDecimal price, boolean inStock) {
    public static BasicProduct create(Product product) {
        return new BasicProduct(product.getId(), product.getName(), product.getPrice(), product.getQuantity() > 0);
    }
}
