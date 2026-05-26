package com.microservicio.pedido.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.pedido.model.Pedido;
import com.microservicio.pedido.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> listar() {
        return service.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id) {
        return service.obtenerPedido(id);
    }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido) {
        return service.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarPedido(id);
    }
    
}
