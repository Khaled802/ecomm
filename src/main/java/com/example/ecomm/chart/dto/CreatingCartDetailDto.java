package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.entity.CartDetail;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreatingCartDetailDto(@NotNull @Positive Integer productId, @NotNull @Positive Integer chartId,
                                    @NotNull @Positive Integer quantity) {
    public CartDetail convertToChartDetail() {
        return CartDetail.builder().productId(productId).chartId(chartId).quantity(quantity).build();
    }
}
