package com.example.ecomm.chart.controller;

import com.example.ecomm.chart.Chart;
import com.example.ecomm.chart.dto.ChartInfoDto;
import com.example.ecomm.chart.dto.CreatingChartDetailDto;
import com.example.ecomm.chart.service.ChartService;
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
public class ChartController {
    private final ChartService chartService;

    @GetMapping
    public List<ChartInfoDto> getAllCharts() {
        return chartService.getAllCharts().stream().map(ChartInfoDto::create).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChartInfoDto createChart() {
        return ChartInfoDto.create(chartService.addNewChart(new Chart()));
    }

    @GetMapping("/{id}")
    public ChartInfoDto getChart(@PathVariable Integer id) {
        Chart chart = chartService.getChartById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found chart"));
        return ChartInfoDto.create(chart);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChart(@PathVariable Integer id) throws NotFoundException {
        chartService.deleteChartById(id);
    }

    @PostMapping("/details")
    @ResponseStatus(HttpStatus.CREATED)
    public void getChartDetail(@RequestBody @Valid CreatingChartDetailDto chartDetailDto) throws NotFoundException {
        chartService.addChartDetail(chartDetailDto.convertToChartDetail());
    }

    @DeleteMapping("/details/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChartDetail(@PathVariable Integer id) throws NotFoundException {
        chartService.removeChartDetail(id);
    }
}
