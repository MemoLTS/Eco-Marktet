package com.caso3.catalogo.service;

import org.springframework.stereotype.Service;

import com.caso3.catalogo.client.ProductClient;

@Service
public class CatalogService {

    private final ProductClient productClient;

    public CatalogService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public String verCatalogo() {
        return productClient.obtenerProductos();
    }
}