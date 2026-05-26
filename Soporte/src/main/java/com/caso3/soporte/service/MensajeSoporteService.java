package com.caso3.soporte.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caso3.soporte.dto.MensajeSoporteDTO;
import com.caso3.soporte.exception.BusinessException;
import com.caso3.soporte.exception.ResourceNotFoundException;
import com.caso3.soporte.model.MensajeSoporte;
import com.caso3.soporte.model.TicketSoporte;
import com.caso3.soporte.repository.MensajeSoporteRepository;
import com.caso3.soporte.repository.TicketSoporteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MensajeSoporteService {

    private final MensajeSoporteRepository mensajeSoporteRepository;
    private final TicketSoporteRepository ticketSoporteRepository;

    public List<MensajeSoporte> listarPorIdTicket(Long idTicket) {
        return mensajeSoporteRepository.findByTicketSoporteIdTicket(idTicket);
    }

    public MensajeSoporte obtenerMensajePorId(Long idMensaje) {
        return mensajeSoporteRepository.findById(idMensaje)
            .orElseThrow(() -> new ResourceNotFoundException("Mensaje", idMensaje));
    }

    public MensajeSoporte enviarMensaje(Long idTicket, MensajeSoporteDTO dto) {
        log.info("Enviando mensaje al ticket id: {}", idTicket);

        TicketSoporte ticket = ticketSoporteRepository.findById(idTicket)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket", idTicket));

        if ("CERRADO".equals(ticket.getEstadoTicket())) {
            throw new BusinessException("No se pueden enviar mensajes a un ticket cerrado");
        }

        MensajeSoporte mensaje = MensajeSoporte.builder()
            .contenido(dto.getContenido())
            .remitente(dto.getRemitente())
            .tipoRemitente(dto.getTipoRemitente())
            .fechaEnvio(LocalDateTime.now())
            .ticketSoporte(ticket)
            .build();

        return mensajeSoporteRepository.save(mensaje);
    }

    public MensajeSoporte responderMensaje(Long idMensajeOriginal, MensajeSoporteDTO dto) {
        log.info("Respondiendo al mensaje {}", idMensajeOriginal);
        MensajeSoporte original = obtenerMensajePorId(idMensajeOriginal);
        return enviarMensaje(original.getTicketSoporte().getIdTicket(), dto);
    }

    public void eliminarMensaje(Long id) {
        if (!mensajeSoporteRepository.existsById(id))
            throw new ResourceNotFoundException("Mensaje", id);
        mensajeSoporteRepository.deleteById(id);
    }

}
