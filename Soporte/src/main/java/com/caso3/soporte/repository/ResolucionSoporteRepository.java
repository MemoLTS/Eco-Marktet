package com.caso3.soporte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caso3.soporte.model.ResolucionSoporte;

@Repository
public interface ResolucionSoporteRepository extends JpaRepository<ResolucionSoporte, Long> {

    Optional<ResolucionSoporte> findByTicketSoporteIdTicket(Long idTicket);

}
