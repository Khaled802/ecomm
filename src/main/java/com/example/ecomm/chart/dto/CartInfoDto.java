package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.Cart;

import java.util.List;

public record CartInfoDto(Integer chartId, String name, List<CartDetailInfoDto> chartDetailInfosDto) {
    public static CartInfoDto create(Cart cart) {
         return new CartInfoDto(cart.getId(), cart.getName(),
                cart.getCartDetails().stream().map(CartDetailInfoDto::create).toList());
    }
}
