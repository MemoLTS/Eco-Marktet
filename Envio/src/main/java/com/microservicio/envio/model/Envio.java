package com.microservicio.envio.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    private String direccionEntrega;

    private Date fechaSalida;

    private Date fechaEntrega;

    private Long pedidoId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ruta ruta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "envio_id")
    private List<Seguimiento> seguimientos;

    public void setFechaEntrega(java.util.Date date) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaEntrega'");
    }

    public void setFechaSalida(java.util.Date date) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaSalida'");
    }
}
