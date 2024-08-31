package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.entity.ChartDetail;
import com.example.ecomm.product.dto.BasicProduct;


public record ChartDetailInfoDto(Integer id, BasicProduct product, Integer quantity) {
    public static ChartDetailInfoDto create(ChartDetail chartDetail) {
        return new ChartDetailInfoDto(
                chartDetail.getId(), BasicProduct.create(chartDetail.getProduct()), chartDetail.getQuantity()
        );
    }
}
