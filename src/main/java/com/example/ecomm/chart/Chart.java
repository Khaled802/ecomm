package com.example.ecomm.chart;

import com.example.ecomm.chart.entity.ChartDetail;
import com.example.ecomm.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "charts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Chart {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "chart_id", sequenceName = "chart_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "chart_id", strategy = GenerationType.SEQUENCE)
    private Integer id;


    @OneToMany(mappedBy = "chart", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<ChartDetail> chartDetails = new LinkedHashSet<>();

    public void addChartDetail(ChartDetail chartDetail) {
        chartDetail.setChart(this);
        this.chartDetails.add(chartDetail);
    }

    public void removeChartDetail(ChartDetail chartDetail) {
        chartDetail.setChart(null);
        this.chartDetails.remove(chartDetail);
    }
}
