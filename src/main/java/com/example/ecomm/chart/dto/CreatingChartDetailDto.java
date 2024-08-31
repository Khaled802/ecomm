package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.entity.ChartDetail;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreatingChartDetailDto(@NotNull @Positive Integer productId, @NotNull @Positive Integer chartId,
                                     @NotNull @Positive Integer quantity) {
    public ChartDetail convertToChartDetail() {
        return ChartDetail.builder().productId(productId).chartId(chartId).quantity(quantity).build();
    }
}
