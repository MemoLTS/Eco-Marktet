package com.microservicio.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
