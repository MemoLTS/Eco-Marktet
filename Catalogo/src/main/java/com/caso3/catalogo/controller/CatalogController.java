package com.caso3.catalogo.controller;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import com.caso3.catalogo.model.Catalogo;
import com.caso3.catalogo.repository.CatalogRepository;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class CatalogController {

    private final CatalogRepository repo;

    public CatalogController(CatalogRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Catalogo> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Catalogo guardar(@RequestBody @NonNull Catalogo catalogo) {
        return repo.save(catalogo);
    }
}