package com.caso3.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caso3.catalogo.model.Catalogo;

public interface CatalogRepository extends JpaRepository<Catalogo, Long> {
}