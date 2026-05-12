package com.cristian.restaurante_api.service;

import com.cristian.restaurante_api.model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido crearPedido(Pedido pedido);

    List<Pedido> listarPedidos();

    Pedido cambiarEstado(Long id, String estado);
}