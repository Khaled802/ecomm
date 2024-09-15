package com.example.ecomm.chart.entity;

import com.example.ecomm.chart.Cart;
import com.example.ecomm.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chart_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartDetail {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "chartDetail_id", sequenceName = "chart_details_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "chartDetail_id", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "chart_id", referencedColumnName = "id", nullable = false)
    private Cart cart;

    @Column(name = "quantity")
    private Integer quantity;


    @Transient
    private Integer productId;

    @Transient
    private Integer chartId;
}
