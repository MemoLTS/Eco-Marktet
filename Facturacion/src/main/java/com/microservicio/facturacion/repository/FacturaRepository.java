package com.microservicio.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.facturacion.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{
    
}
