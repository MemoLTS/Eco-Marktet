package com.microservicio.facturacion.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "transaccion", url = "http://localhost:8084")
public interface TransaccionClient {

    @GetMapping("/transacciones")
    String obtenerTransacciones();
}