package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.Cart;

public record CreatingCartDto(String name) {
    public Cart convertToCart() {
        return Cart.builder().name(this.name()).build();
    }
}
