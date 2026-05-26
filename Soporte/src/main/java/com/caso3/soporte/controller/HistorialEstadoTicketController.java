package com.caso3.soporte.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caso3.soporte.model.HistorialEstadoTicket;
import com.caso3.soporte.service.HistorialEstadoTicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/historialEstadoTicket")
@RequiredArgsConstructor

public class HistorialEstadoTicketController {

    private final HistorialEstadoTicketService historialEstadoTicketService;

    @GetMapping("/listar/{idTicket}")
    public ResponseEntity<List<HistorialEstadoTicket>> listarPorIdTicket(@PathVariable Long idTicket) {
        return ResponseEntity.ok(historialEstadoTicketService.listarPorIdTicket(idTicket));
    }

    @GetMapping("/{idHistorial}")
    public ResponseEntity<HistorialEstadoTicket> obtenerHistorialPorId(@PathVariable Long idHistorial) {
        return ResponseEntity.ok(historialEstadoTicketService.obtenerHistorialPorId(idHistorial));
    }

}
