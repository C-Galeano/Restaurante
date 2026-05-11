package com.cristian.restaurante_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mesas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private int capacidad;

    private boolean disponible;
}