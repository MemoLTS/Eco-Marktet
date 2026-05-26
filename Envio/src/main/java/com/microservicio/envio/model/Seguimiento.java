package com.microservicio.envio.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaHora;

    private String ubicacion;

    private String estado;

    private String descripcion;

    public void setFechaHora(java.util.Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFechaHora'");
    }
}
