package com.cristian.restaurante_api.repository;

import com.cristian.restaurante_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}