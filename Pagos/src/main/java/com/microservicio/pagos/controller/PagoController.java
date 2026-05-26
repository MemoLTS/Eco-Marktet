package com.microservicio.pagos.controller;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.pagos.model.Pago;
import com.microservicio.pagos.model.VentaRequest;
import com.microservicio.pagos.service.PagoService;

@RestController
@RequestMapping("api/pagos")
public class PagoController {
    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pago> listar() {
        return service.listarPagos();
    }

    @GetMapping("/{id}")
    public Pago obtener(@PathVariable @NonNull Long id) {
        return service.obtenerPago(id);
    }

    @PostMapping
    public Pago procesar(@RequestBody @NonNull Pago pago) {
        return service.procesarPago(pago);
    }

    @PostMapping("/venta")
    public Pago registrarVenta(@RequestBody VentaRequest venta, @PathVariable @NonNull Long id) {
        return service.registrarVenta(venta, id);
    }



    @PostMapping("/reembolso")
    public Pago procesarReembolso(@RequestBody VentaRequest venta) {
        return service.procesarReembolso(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable @NonNull Long id) {
        service.eliminarPago(id);
    }
}
