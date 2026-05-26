package com.caso3.catalogo.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "inventario", url = "http://localhost:8083")
public interface ProductClient {

    @GetMapping("/productos")
    String obtenerProductos();
}
