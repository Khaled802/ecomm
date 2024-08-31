package com.example.ecomm.chart.dto;

import com.example.ecomm.chart.Chart;

import java.util.List;

public record ChartInfoDto(Integer chartId, List<ChartDetailInfoDto> chartDetailInfosDto) {
    public static ChartInfoDto create(Chart chart) {
         return new ChartInfoDto(chart.getId(),
                chart.getChartDetails().stream().map(ChartDetailInfoDto::create).toList());
    }
}
