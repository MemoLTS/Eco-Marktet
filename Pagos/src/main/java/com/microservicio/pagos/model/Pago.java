package com.microservicio.pagos.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;
    private LocalDate fecha;
    private String estado;
    private String metodo;
    private Long facturaId;
    @OneToOne(cascade = CascadeType.ALL)
    private Transaccion transaccion;
}
