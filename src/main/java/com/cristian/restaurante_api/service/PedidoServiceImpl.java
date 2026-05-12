package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Pedido;
import com.cristian.restaurante_api.repository.PedidoRepository;
import com.cristian.restaurante_api.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido crearPedido(Pedido pedido) {

        pedido.setFecha(LocalDateTime.now());

        double total = 0;

        for (var detalle : pedido.getDetalles()) {

            detalle.setPedido(pedido);

            double subtotal =
                    detalle.getCantidad() *
                            detalle.getProducto().getPrecio();

            detalle.setSubtotal(subtotal);

            total += subtotal;
        }

        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido cambiarEstado(Long id, String estado) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow();

        pedido.setEstado(estado);

        return pedidoRepository.save(pedido);
    }
}