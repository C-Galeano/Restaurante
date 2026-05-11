package com.cristian.restaurante_api.repository;

import com.cristian.restaurante_api.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}