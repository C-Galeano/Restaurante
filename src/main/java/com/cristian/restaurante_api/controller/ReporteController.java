package com.cristian.restaurante_api.controller;

import com.cristian.restaurante_api.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final FacturaRepository facturaRepository;

    @GetMapping("/ventas")
    public Double totalVentas() {
        return facturaRepository.totalVentas();
    }
}