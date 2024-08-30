package com.example.ecomm.product.dto;

import com.example.ecomm.product.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdatedProduct(@NotNull String name,
                             @NotNull @PositiveOrZero BigDecimal price,
                             @NotNull @PositiveOrZero Integer quantity) {
    public Product toProduct() {
        return Product.builder().name(name).price(price).quantity(quantity).build();
    }
}
