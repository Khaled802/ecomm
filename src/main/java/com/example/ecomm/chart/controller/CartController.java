package com.example.ecomm.chart.controller;

import com.example.ecomm.chart.Cart;
import com.example.ecomm.chart.dto.CartInfoDto;
import com.example.ecomm.chart.dto.CreatingCartDetailDto;
import com.example.ecomm.chart.dto.CreatingCartDto;
import com.example.ecomm.chart.dto.UpdatingCartDto;
import com.example.ecomm.chart.service.CartService;
import com.example.ecomm.exception.customExceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/charts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<CartInfoDto> getAllCharts() {
        return cartService.getAllCharts().stream().map(CartInfoDto::create).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartInfoDto createChart(@RequestBody CreatingCartDto creatingCartDto) {
        return CartInfoDto.create(creatingCartDto.convertToCart());
    }

    @GetMapping("/{id}")
    public CartInfoDto getChart(@PathVariable Integer id) {
        Cart cart = cartService.getChartById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found chart"));
        return CartInfoDto.create(cart);
    }

    @PutMapping("/{id}")
    public CartInfoDto updateChart(@PathVariable Integer id, UpdatingCartDto updatingCartDto) throws NotFoundException {
        Cart cart = updatingCartDto.convertToCart();
        cart.setId(id);
        return CartInfoDto.create(cartService.update(cart));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChart(@PathVariable Integer id) throws NotFoundException {
        cartService.deleteChartById(id);
    }

    @PostMapping("/details")
    @ResponseStatus(HttpStatus.CREATED)
    public void getChartDetail(@RequestBody @Valid CreatingCartDetailDto chartDetailDto) throws NotFoundException {
        cartService.addChartDetail(chartDetailDto.convertToChartDetail());
    }

    @DeleteMapping("/details/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChartDetail(@PathVariable Integer id) throws NotFoundException {
        cartService.removeChartDetail(id);
    }
}
