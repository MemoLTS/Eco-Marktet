package com.microservicio.envio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.envio.model.Envio;
import com.microservicio.envio.service.EnvioService;

@RestController
@RequestMapping("api/envios")
public class EnvioController {
    private final EnvioService service;

    public EnvioController(EnvioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Envio> listar() {
        return service.listarEnvios();
    }

    @GetMapping("/{id}")
    public Envio obtener(@PathVariable Long id) {
        return service.obtenerEnvio(id);
    }

    @PostMapping
    public Envio crear(@RequestBody Envio envio) {
        return service.crearEnvio(envio);
    }

    @PutMapping("/{id}/estado")
    public Envio actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {

        return service.actualizarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarEnvio(id);
    }
}
