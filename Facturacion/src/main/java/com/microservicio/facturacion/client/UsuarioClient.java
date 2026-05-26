package com.microservicio.facturacion.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "usuario", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("/usuarios")
    String obtenerUsuarios();
}