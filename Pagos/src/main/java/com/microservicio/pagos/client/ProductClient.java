package com.microservicio.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservicio.pagos.dto.ProductDto;

@FeignClient(name = "inventario", url = "http://localhost:8083")
public interface ProductClient {

    @GetMapping("/api/v1/ecomarket/inventario/productos/{id}")
    ProductDto obtenerProducto(@PathVariable("id") Long id);

    @PutMapping("/api/v1/ecomarket/inventario/updateprod/{id}/stock")
    void updateStock(@PathVariable("id") Long id,
                     @RequestBody int stock);
}