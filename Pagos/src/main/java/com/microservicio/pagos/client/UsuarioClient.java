package com.microservicio.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.microservicio.pagos.dto.UsuarioDTO;


@FeignClient(name = "usuarios", url = "http://localhost:8090")
public interface UsuarioClient {

    @GetMapping("/api/ecomarket/usuario/usuarios/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable Long id);
}