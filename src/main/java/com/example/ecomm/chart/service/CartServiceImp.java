package com.example.ecomm.chart.service;

import com.example.ecomm.chart.Cart;
import com.example.ecomm.chart.entity.CartDetail;
import com.example.ecomm.chart.repository.ChartDetailRepository;
import com.example.ecomm.chart.repository.CartRepository;
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
public class CartServiceImp implements CartService {
    private final CartRepository cartRepository;
    private final ChartDetailRepository chartDetailRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Cart> getAllCharts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addNewChart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> getChartById(Integer id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart update(Cart cart) throws NotFoundException {
        if (!cartRepository.existsById(cart.getId()))
            throw new NotFoundException("Chart");
        return cartRepository.save(cart);
    }

    @Override
    public void deleteChartById(Integer id) throws NotFoundException {
        if (!cartRepository.existsById(id))
            throw new NotFoundException("Chart");
        cartRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addChartDetail(CartDetail cartDetail) throws NotFoundException {
        Cart cart = cartRepository.findById(cartDetail.getChartId()).orElseThrow(()-> new NotFoundException("Chart"));
        Product product = productRepository.findById(cartDetail.getProductId()).orElseThrow(()-> new NotFoundException("Product"));
        cartDetail.setProduct(product);
        cart.addChartDetail(cartDetail);
    }

    @Override
    @Transactional
    public void removeChartDetail(Integer chartDetailId) throws NotFoundException {
        CartDetail cartDetail = chartDetailRepository.findById(chartDetailId).orElseThrow(() -> new NotFoundException("ChartDetail"));
        cartDetail.getCart().removeChartDetail(cartDetail);
    }
}
