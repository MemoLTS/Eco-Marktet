package com.microservicio.envio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservicio.envio.model.Envio;
import com.microservicio.envio.model.Seguimiento;
import com.microservicio.envio.repository.EnvioRepository;

@Service
public class EnvioService {
     private final EnvioRepository repository;

    public EnvioService(EnvioRepository repository) {
        this.repository = repository;
    }

    public List<Envio> listarEnvios() {
        return repository.findAll();
    }

    public Envio crearEnvio(Envio envio) {

        envio.setFechaSalida(new Date());

        if (envio.getSeguimientos() != null) {

            for (Seguimiento seguimiento : envio.getSeguimientos()) {

                seguimiento.setFechaHora(new Date());
            }
        }

        return repository.save(envio);
    }

    public Envio obtenerEnvio(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Envio actualizarEstado(Long id, String estado) {

        Envio envio = repository.findById(id).orElse(null);

        if (envio != null) {

            envio.setEstado(estado);

            if (estado.equalsIgnoreCase("ENTREGADO")) {
                envio.setFechaEntrega(new Date());
            }

            return repository.save(envio);
        }

        return null;
    }

    public void eliminarEnvio(Long id) {
        repository.deleteById(id);
    }
}
