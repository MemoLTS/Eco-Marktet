package com.caso3.usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.caso3.usuario.model.Usuario;
import com.caso3.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> readAllUsuarios() {
        return repository.findAll();
    }

    public Usuario register(@NonNull Usuario usuario) {
        return repository.save(usuario);
    }
    public Usuario readUsuarioById(@NonNull Long id) {
        return repository.findById(id).orElse(null);
    }
    public Usuario updateUsuario(@NonNull Long id, Usuario updatedUsuario) {
        return repository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(updatedUsuario.getNombre());
                    usuario.setDv(updatedUsuario.getDv());
                    usuario.setEmail(updatedUsuario.getEmail());
                    usuario.setContraseña(updatedUsuario.getContraseña());
                    return repository.save(usuario);
                })
                .orElse(null);
    }

    public boolean deleteUsuario(@NonNull Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public void seeduser() {

        List<Usuario> usuarios = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setNombre("Humberto Eduardo San Juan Perez");
        u1.setRut(12039367);
        u1.setDv("7");
        u1.setEmail("HumbertoEduardoSanJuanPerez@example.com");
        u1.setContraseña("HumbertoEduardoSanJuanPerez123");
        u1.setRol("admin");

        Usuario u2 = new Usuario();
        u2.setNombre("Maria Fernanda Gonzalez Ramirez");
        u2.setRut(98765432);
        u2.setDv("1");
        u2.setEmail("MariaFernandaGonzalezRamirez@example.com");
        u2.setContraseña("MariaFernandaGonzalezRamirez123");
        u2.setRol("comprador");

        usuarios.add(u1);
        usuarios.add(u2);
        repository.saveAll(usuarios);
    }
}
