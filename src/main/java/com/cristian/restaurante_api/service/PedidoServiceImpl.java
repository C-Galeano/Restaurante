package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Mesa;
import com.cristian.restaurante_api.model.Pedido;
import com.cristian.restaurante_api.repository.MesaRepository;
import com.cristian.restaurante_api.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MesaRepository mesaRepository;

    @Override
    public Pedido crearPedido(Pedido pedido) {

        pedido.setId(null);
        pedido.setFecha(LocalDateTime.now());

        double total = 0;

        for (var detalle : pedido.getDetalles()) {

            detalle.setId(null);
            detalle.setPedido(pedido);

            double subtotal =
                    detalle.getCantidad() *
                            detalle.getProducto().getPrecio();

            detalle.setSubtotal(subtotal);

            total += subtotal;
        }

        pedido.setTotal(total);

        // Marcar mesa como ocupada
        Mesa mesa = mesaRepository.findById(pedido.getMesa().getId())
                .orElseThrow();
        mesa.setDisponible(false);
        mesaRepository.save(mesa);

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

        // Si se paga, liberar la mesa
        if (estado.equals("PAGADO")) {
            Mesa mesa = mesaRepository.findById(pedido.getMesa().getId())
                    .orElseThrow();
            mesa.setDisponible(true);
            mesaRepository.save(mesa);
        }

        return pedidoRepository.save(pedido);
    }
}