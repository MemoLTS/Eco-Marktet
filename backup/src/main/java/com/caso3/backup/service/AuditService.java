package com.caso3.backup.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuditService {
    private final RestTemplate restTemplate = new RestTemplate();

    private void notificarCambio(String accion, Object p) {
        Map<String, Object> log = new HashMap<>();
        log.put("accion", accion);
        log.put("producto", p);

        restTemplate.postForObject(
            "http://localhost:8090/audit",
            log,
            String.class
        );
    }

    public void guardar(Map<String, Object> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        String accion = data.containsKey("accion")
            ? String.valueOf(data.get("accion"))
            : "guardar";
        Object producto = data.get("producto");

        notificarCambio(accion, producto);
    }
}