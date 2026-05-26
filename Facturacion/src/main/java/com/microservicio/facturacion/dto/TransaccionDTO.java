package com.microservicio.facturacion.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TransaccionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtransaccion;

    private long idpago;
    private long idusuario;

    private LocalDate fecha;
    private String estado;
    private String respuesta;


}