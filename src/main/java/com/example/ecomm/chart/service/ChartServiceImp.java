package com.example.ecomm.chart.service;

import com.example.ecomm.chart.Chart;
import com.example.ecomm.chart.entity.ChartDetail;
import com.example.ecomm.chart.repository.ChartDetailRepository;
import com.example.ecomm.chart.repository.ChartRepository;
import com.example.ecomm.exception.customExceptions.NotFoundException;
import com.example.ecomm.product.Product;
import com.example.ecomm.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChartServiceImp implements ChartService {
    private final ChartRepository chartRepository;
    private final ChartDetailRepository chartDetailRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Chart> getAllCharts() {
        return chartRepository.findAll();
    }

    @Override
    public Chart addNewChart(Chart chart) {
        return chartRepository.save(chart);
    }

    @Override
    public Optional<Chart> getChartById(Integer id) {
        return chartRepository.findById(id);
    }

    @Override
    public void deleteChartById(Integer id) throws NotFoundException {
        if (!chartRepository.existsById(id))
            throw new NotFoundException("Chart");
        chartRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addChartDetail(ChartDetail chartDetail) throws NotFoundException {
        Chart chart = chartRepository.findById(chartDetail.getChartId()).orElseThrow(()-> new NotFoundException("Chart"));
        Product product = productRepository.findById(chartDetail.getProductId()).orElseThrow(()-> new NotFoundException("Product"));
        chartDetail.setProduct(product);
        chart.addChartDetail(chartDetail);
    }

    @Override
    @Transactional
    public void removeChartDetail(Integer chartDetailId) throws NotFoundException {
        ChartDetail chartDetail = chartDetailRepository.findById(chartDetailId).orElseThrow(() -> new NotFoundException("ChartDetail"));
        chartDetail.getChart().removeChartDetail(chartDetail);
    }
}
