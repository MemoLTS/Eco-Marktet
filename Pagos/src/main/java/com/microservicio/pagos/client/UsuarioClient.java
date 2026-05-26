package com.microservicio.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.microservicio.pagos.dto.UsuarioDTO;


@FeignClient(name = "usuario", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("/api/ecomarket/users/usuarios/{id}")
    UsuarioDTO obtenerUsuario(@PathVariable("id") Long idusuario);


}