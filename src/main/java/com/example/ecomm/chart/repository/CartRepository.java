package com.example.ecomm.chart.repository;

import com.example.ecomm.chart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
