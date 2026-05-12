package com.cristian.restaurante_api.controller;

import com.cristian.restaurante_api.model.Factura;
import com.cristian.restaurante_api.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;

    @PostMapping("/{pedidoId}")
    public Factura generarFactura(
            @PathVariable Long pedidoId
    ) {
        return facturaService.generarFactura(pedidoId);
    }
}