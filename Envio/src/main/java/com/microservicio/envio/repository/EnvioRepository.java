package com.microservicio.envio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.envio.model.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Long>  {
    
}
