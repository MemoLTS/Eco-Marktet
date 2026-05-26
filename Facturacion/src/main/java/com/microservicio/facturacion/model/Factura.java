package com.microservicio.facturacion.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private Date fechaEmision;

    private Double total;

    private String estado;

    private Long pedidoId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private List<DetalleFactura> detalles;
}
