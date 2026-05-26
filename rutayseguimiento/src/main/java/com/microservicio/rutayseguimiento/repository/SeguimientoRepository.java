package com.microservicio.rutayseguimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.rutayseguimiento.model.Seguimiento;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long>{


    List<Seguimiento> findByEnvioId(Long envioId);
}
