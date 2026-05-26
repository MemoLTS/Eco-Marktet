package com.caso3.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caso3.tienda.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository <Tienda, Long>{
    
}
