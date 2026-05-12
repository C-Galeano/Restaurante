package com.cristian.restaurante_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    private Double subtotal;

    private Double impuesto;

    private Double total;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}