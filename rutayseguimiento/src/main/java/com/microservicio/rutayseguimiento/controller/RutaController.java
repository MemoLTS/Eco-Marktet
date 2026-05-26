package com.microservicio.rutayseguimiento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.rutayseguimiento.model.Ruta;
import com.microservicio.rutayseguimiento.model.Seguimiento;
import com.microservicio.rutayseguimiento.service.RutaService;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {
    
     private final RutaService service;

    public RutaController(RutaService service) {
        this.service = service;
    }

    // RUTAS

    @GetMapping
    public List<Ruta> listarRutas() {
        return service.listarRutas();
    }

    @PostMapping
    public Ruta guardarRuta(@RequestBody Ruta ruta) {
        return service.guardarRuta(ruta);
    }

    // SEGUIMIENTO

    @PostMapping("/seguimiento")
    public Seguimiento registrarSeguimiento(
            @RequestBody Seguimiento seguimiento) {

        return service.registrarSeguimiento(seguimiento);
    }

    @GetMapping("/seguimiento/{envioId}")
    public List<Seguimiento> obtenerSeguimiento(
            @PathVariable Long envioId) {

        return service.obtenerSeguimientoEnvio(envioId);
    }
}
