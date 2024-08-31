package com.example.ecomm.chart.service;

import com.example.ecomm.chart.Chart;
import com.example.ecomm.chart.entity.ChartDetail;
import com.example.ecomm.exception.customExceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ChartService {
    List<Chart> getAllCharts();
    Chart addNewChart(Chart chart);
    Optional<Chart> getChartById(Integer id);
    void deleteChartById(Integer id) throws NotFoundException;
    void addChartDetail(ChartDetail chartDetail) throws NotFoundException;
    void removeChartDetail(Integer chartDetailId) throws NotFoundException;
}
