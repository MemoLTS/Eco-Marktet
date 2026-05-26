package com.microservicio.rutayseguimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.rutayseguimiento.model.Ruta;

public interface RutaRepository extends JpaRepository<Ruta, Long> {
    
}
