package com.microservicio.pagos.service;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.microservicio.pagos.client.ProductClient;
import com.microservicio.pagos.dto.ProductDto;
import com.microservicio.pagos.dto.UsuarioDTO;
import com.microservicio.pagos.model.Pago;
import com.microservicio.pagos.model.Transaccion;
import com.microservicio.pagos.model.VentaRequest;
import com.microservicio.pagos.repository.PagoRepository;

import com.microservicio.pagos.client.UsuarioClient;


@Service
public class PagoService {
    private final PagoRepository repository;
    private final ProductClient productClient;
    private final UsuarioClient usuarioClient;

    public PagoService(PagoRepository repository, ProductClient productClient, UsuarioClient usuarioClient) {
        this.repository = repository;
        this.productClient = productClient;
        this.usuarioClient = usuarioClient;
    }

    public List<Pago> listarPagos() {
        return repository.findAll();
    }

    public Pago procesarReembolso(VentaRequest venta) {
        ProductDto producto = productClient.obtenerProducto(venta.getProductId());
        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }
        int nuevoStock = producto.getStock() + venta.getCantidad();
        productClient.updateStock(producto.getId(), nuevoStock);
        Pago pago = venta.getPago();
        pago.setFecha(LocalDate.now());
        pago.setEstado("REEMBOLSO");
        return repository.save(pago);
    }

    public Pago procesarDevolucion(VentaRequest venta) {
        ProductDto producto = productClient.obtenerProducto(venta.getProductId());
        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }
        int nuevoStock = producto.getStock() + venta.getCantidad();
        productClient.updateStock(producto.getId(), nuevoStock);
        Pago pago = venta.getPago();
        pago.setFecha(LocalDate.now());
        pago.setEstado("DEVOLUCION");
        return repository.save(pago);
    }

    public Pago registrarVenta(VentaRequest venta, Long usuarioId) {

        UsuarioDTO user = usuarioClient.obtenerUsuario(usuarioId);

        if (user == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        ProductDto producto = productClient.obtenerProducto(venta.getProductId());

        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }

        if(producto.getStock() < venta.getCantidad()){
            throw new RuntimeException("Stock insuficiente");
        }

        int nuevoStock = producto.getStock() - venta.getCantidad();

        productClient.updateStock(producto.getId(), nuevoStock);

        Pago pago = venta.getPago();

        pago.setFecha(LocalDate.now());
        pago.setEstado("PAGADO");

        // GUARDAR PRIMERO EL PAGO
        Pago pagoGuardado = repository.save(pago);

        // CREAR TRANSACCION
        Transaccion transaccion = new Transaccion();

        transaccion.setFecha(LocalDate.now());
        transaccion.setIdpago(pagoGuardado.getId());
        transaccion.setIdusuario(user.getUsuarioId());
        transaccion.setEstado("APROBADA");
        transaccion.setRespuesta("Venta realizada correctamente");

        // ASIGNAR TRANSACCION
        pagoGuardado.setTransaccion(transaccion);

        // GUARDAR NUEVAMENTE
        return repository.save(pagoGuardado);
    }

    public Pago procesarPago(@NonNull Pago pago) {

        Transaccion transaccion = new Transaccion();

        transaccion.setFecha(LocalDate.now());

        // Simulación simple
        if (pago.getMonto() > 0) {

            transaccion.setEstado("APROBADA");
            transaccion.setRespuesta("Pago procesado correctamente");

            pago.setEstado("CONFIRMADO");

        } else {

            transaccion.setEstado("RECHAZADA");
            transaccion.setRespuesta("Monto inválido");

            pago.setEstado("RECHAZADO");
        }

        pago.setFecha(LocalDate.now());
        Transaccion transa = new Transaccion();

        transa.setFecha(LocalDate.now());
        transa.setEstado("APROBADA");
        transa.setRespuesta("Venta realizada correctamente");

        pago.setTransaccion(transa);

        return repository.save(pago);
    }

    public Pago obtenerPago(@NonNull Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminarPago(@NonNull Long id) {
        repository.deleteById(id);
    }
}
