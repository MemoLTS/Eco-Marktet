package com.caso3.soporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caso3.soporte.model.HistorialEstadoTicket;

@Repository
public interface HistorialEstadoTicketRepository extends JpaRepository<HistorialEstadoTicket, Long> {

    List<HistorialEstadoTicket> findByTicketSoporteIdTicketOrderByFechaCambioAsc(Long idTicket);

}
