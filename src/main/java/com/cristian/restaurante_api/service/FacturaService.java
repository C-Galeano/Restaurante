package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Factura;

public interface FacturaService {

    Factura generarFactura(Long pedidoId);
}