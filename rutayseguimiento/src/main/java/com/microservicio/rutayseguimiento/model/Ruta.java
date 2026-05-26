package com.microservicio.rutayseguimiento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;

    private String destino;

    private Double distanciaKm;

    private Integer tiempoEstimado;

    private String estado;

    private String conductor;

    private String vehiculo;

    public void optimizarRuta() {

        this.estado = "OPTIMIZADA";
    }
}
