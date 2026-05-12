package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Factura;
import com.cristian.restaurante_api.model.Pedido;
import com.cristian.restaurante_api.repository.FacturaRepository;
import com.cristian.restaurante_api.repository.PedidoRepository;
import com.cristian.restaurante_api.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;
    private final PedidoRepository pedidoRepository;

    @Override
    public Factura generarFactura(Long pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow();

        double subtotal = pedido.getTotal();
        double impuesto = subtotal * 0.19;
        double total = subtotal + impuesto;

        Factura factura = Factura.builder()
                .fecha(LocalDateTime.now())
                .pedido(pedido)
                .subtotal(subtotal)
                .impuesto(impuesto)
                .total(total)
                .build();

        pedido.setEstado("PAGADO");

        return facturaRepository.save(factura);
    }
}