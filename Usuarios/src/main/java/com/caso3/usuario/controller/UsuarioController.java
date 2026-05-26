package com.caso3.usuario.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caso3.usuario.model.Usuario;
import com.caso3.usuario.service.UsuarioService;

@RestController
@RequestMapping("/api/ecomarket/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // Obtener todos los usuarios
    @GetMapping("/usuario")
    public List<Usuario> getUsuarios() {
        return service.readAllUsuarios();
    }

    // Seed de usuarios
    @GetMapping("/seed")
    public ResponseEntity<?> seedusuarios() {
        service.seeduser();
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuarios cargados correctamente");
    }

    // Agregar usuario
    @PostMapping("/register")
    public ResponseEntity<?> postUsuario(
            @Valid @RequestBody Usuario usuario) {

        Usuario u = service.register(usuario);

        if (u != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Usuario registrado");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error al registrar usuario");
    }

    // Buscar usuario por ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {

        Usuario usuario = service.readUsuarioById(id);

        if (usuario != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(usuario);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado");
    }

    // Actualizar usuario
    @PutMapping("/updateusuario/{id}")
    public ResponseEntity<?> updateUsuario(
            @PathVariable Long id,
            @Valid @RequestBody Usuario usuario) {

        Usuario u = service.updateUsuario(id, usuario);

        if (u != null) {
            return ResponseEntity.status(HttpStatus.OK)
                        .body("Usuario actualizado");
            }
        

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado");
    }


    // Eliminar usuario
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {

        List<Usuario> usuarios = service.readAllUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {

                service.deleteUsuario(id);

                return ResponseEntity.status(HttpStatus.OK)
                        .body("Usuario eliminado");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado");
    }
}

