package com.microservicio.pedido.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservicio.pedido.model.DetallePedido;
import com.microservicio.pedido.model.Pedido;
import com.microservicio.pedido.repository.PedidoRepository;

@Service
public class PedidoService {
        private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }

    public Pedido guardarPedido(Pedido pedido) {

        double total = 0;

        for (DetallePedido detalle : pedido.getDetalles()) {

            double subtotal =
                    detalle.getCantidad() * detalle.getPrecioUnitario();

            detalle.setSubtotal(subtotal);

            total += subtotal;
        }

        pedido.setTotal(total);

        return repository.save(pedido);
    }

    public Pedido obtenerPedido(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminarPedido(Long id) {
        repository.deleteById(id);
    }
}
