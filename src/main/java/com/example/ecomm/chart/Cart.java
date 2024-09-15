package com.example.ecomm.chart;

import com.example.ecomm.chart.entity.CartDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "charts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cart {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "chart_id", sequenceName = "chart_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "chart_id", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "chart", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<CartDetail> cartDetails = new LinkedHashSet<>();

    public void addChartDetail(CartDetail cartDetail) {
        cartDetail.setCart(this);
        this.cartDetails.add(cartDetail);
    }

    public void removeChartDetail(CartDetail cartDetail) {
        cartDetail.setCart(null);
        this.cartDetails.remove(cartDetail);
    }
}
