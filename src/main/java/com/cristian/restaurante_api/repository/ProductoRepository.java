package com.cristian.restaurante_api.repository;

import com.cristian.restaurante_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}