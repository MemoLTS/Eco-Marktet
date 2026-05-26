package com.caso3.soporte.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caso3.soporte.model.SolicitudDevolucion;

@Repository
public interface SolicitudDevolucionRepository extends JpaRepository<SolicitudDevolucion, Long> {

    Optional<SolicitudDevolucion> findByTicketSoporteIdTicket(Long idTicket);
    List<SolicitudDevolucion> findByEstadoSolicitud(String estadoSolicitud);

}
