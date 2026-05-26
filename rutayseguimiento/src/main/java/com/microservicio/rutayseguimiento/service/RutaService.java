package com.microservicio.rutayseguimiento.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservicio.rutayseguimiento.model.Ruta;
import com.microservicio.rutayseguimiento.model.Seguimiento;
import com.microservicio.rutayseguimiento.repository.RutaRepository;
import com.microservicio.rutayseguimiento.repository.SeguimientoRepository;

@Service
public class RutaService {
    
    private final RutaRepository rutaRepository;

    private final SeguimientoRepository seguimientoRepository;

    public RutaService(
            RutaRepository rutaRepository,
            SeguimientoRepository seguimientoRepository) {

        this.rutaRepository = rutaRepository;
        this.seguimientoRepository = seguimientoRepository;
    }

    // RUTAS

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }

    public Ruta guardarRuta(Ruta ruta) {

        ruta.optimizarRuta();

        return rutaRepository.save(ruta);
    }

    // SEGUIMIENTO

    public Seguimiento registrarSeguimiento(
            Seguimiento seguimiento) {

        seguimiento.setFechaHora(new Date());

        return seguimientoRepository.save(seguimiento);
    }

    public List<Seguimiento> obtenerSeguimientoEnvio(
            Long envioId) {

        return seguimientoRepository.findByEnvioId(envioId);
    }
}
