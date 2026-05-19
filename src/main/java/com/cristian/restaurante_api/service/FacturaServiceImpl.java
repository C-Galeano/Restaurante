package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Factura;
import com.cristian.restaurante_api.model.Mesa;
import com.cristian.restaurante_api.model.Pedido;
import com.cristian.restaurante_api.repository.FacturaRepository;
import com.cristian.restaurante_api.repository.MesaRepository;
import com.cristian.restaurante_api.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;
    private final PedidoRepository pedidoRepository;
    private final MesaRepository mesaRepository;

    @Override
    public Factura generarFactura(Long pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow();

        double subtotal = pedido.getTotal();
        double impuesto = subtotal * 0.19;
        double total    = subtotal + impuesto;

        Factura factura = Factura.builder()
                .fecha(LocalDateTime.now())
                .pedido(pedido)
                .subtotal(subtotal)
                .impuesto(impuesto)
                .total(total)
                .build();

        pedido.setEstado("PAGADO");
        pedidoRepository.save(pedido);

        // Liberar la mesa al facturar
        Mesa mesa = mesaRepository.findById(pedido.getMesa().getId())
                .orElseThrow();
        mesa.setDisponible(true);
        mesaRepository.save(mesa);

        return facturaRepository.save(factura);
    }
}