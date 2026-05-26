package com.caso3.soporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caso3.soporte.model.EvidenciaAdjunta;

@Repository
public interface EvidenciaAdjuntaRepository extends JpaRepository<EvidenciaAdjunta, Long> {

    List<EvidenciaAdjunta> findByTicketSoporteIdTicket(Long idTicket);

}
