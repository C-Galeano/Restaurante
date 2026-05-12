package com.cristian.restaurante_api.repository;

import com.cristian.restaurante_api.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query("SELECT SUM(f.total) FROM Factura f")
    Double totalVentas();
}