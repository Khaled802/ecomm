package com.example.ecomm.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name="products_id", sequenceName = "products_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "products_id", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", precision = 6, scale = 2, nullable = false)
    private BigDecimal price;

    @PositiveOrZero(message = "quantity must be positive or zero")
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity = 0;
}
