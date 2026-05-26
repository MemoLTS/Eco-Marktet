package com.caso3.backup.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caso3.backup.service.AuditService;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService service;

    @PostMapping
    public void registrar(@RequestBody Map<String, Object> data) {
        service.guardar(data);
    }
    @GetMapping("/reporte")
    public String generarReporte() {
        return """
        REPORTE SEMANAL

        - Backups realizados: 5
        - Cambios registrados: 23
        - Errores: 0
        """;
    }

    @GetMapping("/notificaciones")
    public String generarNotificaciones() {
        return "Notificaciones generadas";
    }
}
