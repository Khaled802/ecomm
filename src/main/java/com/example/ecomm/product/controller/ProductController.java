package com.example.ecomm.product.controller;

import com.example.ecomm.exception.customExceptions.NotFoundException;
import com.example.ecomm.product.Product;
import com.example.ecomm.product.dto.BasicProduct;
import com.example.ecomm.product.dto.CreationProduct;
import com.example.ecomm.product.dto.UpdatedProduct;
import com.example.ecomm.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<BasicProduct> getAll() {
        return productService.getAll().stream().map(BasicProduct::create).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody @Valid CreationProduct creationProduct) {
        return productService.create(creationProduct.toProduct());
    }

    @GetMapping("/{id}")
    public BasicProduct getById(@PathVariable Integer id) {
        return BasicProduct.create(
                productService.getById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"))
            );
    }

    @PutMapping("/{id}")
    public BasicProduct update(@RequestBody UpdatedProduct updatedProduct, @PathVariable Integer id) throws NotFoundException {
        Product toBeUpdated = updatedProduct.toProduct();
        toBeUpdated.setId(id);
        return BasicProduct.create(productService.update(toBeUpdated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }


}
