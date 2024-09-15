package com.example.ecomm.chart.service;

import com.example.ecomm.chart.Cart;
import com.example.ecomm.chart.entity.CartDetail;
import com.example.ecomm.exception.customExceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> getAllCharts();
    Cart addNewChart(Cart cart);
    Optional<Cart> getChartById(Integer id);
    Cart update(Cart cart) throws NotFoundException;
    void deleteChartById(Integer id) throws NotFoundException;
    void addChartDetail(CartDetail cartDetail) throws NotFoundException;
    void removeChartDetail(Integer chartDetailId) throws NotFoundException;
}
