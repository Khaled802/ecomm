package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.entity.CartDetail;
import com.example.ecomm.product.dto.BasicProduct;


public record CartDetailInfoDto(Integer id, BasicProduct product, Integer quantity) {
    public static CartDetailInfoDto create(CartDetail cartDetail) {
        return new CartDetailInfoDto(
                cartDetail.getId(), BasicProduct.create(cartDetail.getProduct()), cartDetail.getQuantity()
        );
    }
}
