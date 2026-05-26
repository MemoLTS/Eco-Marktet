package com.caso3.soporte.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caso3.soporte.dto.EvidenciaAdjuntaDTO;
import com.caso3.soporte.exception.ResourceNotFoundException;
import com.caso3.soporte.model.EvidenciaAdjunta;
import com.caso3.soporte.model.TicketSoporte;
import com.caso3.soporte.repository.EvidenciaAdjuntaRepository;
import com.caso3.soporte.repository.TicketSoporteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EvidenciaAdjuntaService {

    private final EvidenciaAdjuntaRepository evidenciaAdjuntaRepository;
    private final TicketSoporteRepository ticketSoporteRepository;

    public List<EvidenciaAdjunta> listarPorIdTicket(Long idTicket) {
        return evidenciaAdjuntaRepository.findByTicketSoporteIdTicket(idTicket);
    }

    public EvidenciaAdjunta obtenerEvidenciaPorId(Long idEvidencia) {
        return evidenciaAdjuntaRepository.findById(idEvidencia)
            .orElseThrow(() -> new ResourceNotFoundException("Evidencia", idEvidencia));
    }

    public EvidenciaAdjunta adjuntarEvidencia(Long idTicket, EvidenciaAdjuntaDTO dto) {
        log.info("Adjuntando evidencia al ticket {}", idTicket);

        TicketSoporte ticket = ticketSoporteRepository.findById(idTicket)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket", idTicket));

        EvidenciaAdjunta evidencia = EvidenciaAdjunta.builder()
            .nombreArchivo(dto.getNombreArchivo())
            .tipoArchivo(dto.getTipoArchivo())
            .urlArchivo(dto.getUrlArchivo())
            .fechaCarga(LocalDateTime.now())
            .ticketSoporte(ticket)
            .build();

        return evidenciaAdjuntaRepository.save(evidencia);
    }

    public void eliminarEvidencia(Long id) {
        log.info("Eliminando evidencia {}", id);
        if (!evidenciaAdjuntaRepository.existsById(id))
            throw new ResourceNotFoundException("Evidencia", id);
        evidenciaAdjuntaRepository.deleteById(id);
    }

}
