package com.example.ecomm.chart.repository;

import com.example.ecomm.chart.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartDetailRepository extends JpaRepository<CartDetail, Integer> {
}