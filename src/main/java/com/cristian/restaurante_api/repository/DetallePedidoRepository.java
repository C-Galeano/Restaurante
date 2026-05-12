package com.cristian.restaurante_api.repository;

import com.cristian.restaurante_api.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}