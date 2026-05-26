package com.microservicio.facturacion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.facturacion.model.Factura;
import com.microservicio.facturacion.service.FacturaService;

@RestController
@RequestMapping("api/facturas")
public class FacturaController {
     private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Factura> listar() {
        return service.listarFacturas();
    }

    @GetMapping("/{id}")
    public Factura obtener(@PathVariable Long id) {
        return service.obtenerFactura(id);
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return service.guardarFactura(factura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarFactura(id);
    }
}
