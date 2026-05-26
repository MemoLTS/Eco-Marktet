package com.microservicio.facturacion.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservicio.facturacion.model.DetalleFactura;
import com.microservicio.facturacion.model.Factura;
import com.microservicio.facturacion.repository.FacturaRepository;

@Service
public class FacturaService {
    private final FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    public List<Factura> listarFacturas() {
        return repository.findAll();
    }

    public Factura guardarFactura(Factura factura) {

        double total = 0;

        for (DetalleFactura detalle : factura.getDetalles()) {

            double subtotal =
                    detalle.getCantidad() * detalle.getPrecioUnitario();

            detalle.setSubtotal(subtotal);

            total += subtotal;
        }

        factura.setTotal(total);

        factura.setNumero(UUID.randomUUID().toString());

        return repository.save(factura);
    }

    public Factura obtenerFactura(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminarFactura(Long id) {
        repository.deleteById(id);
    }
}
