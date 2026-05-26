package com.caso3.catalogo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Catalogo {

    @Id
    private Long id;

    private String nombre;
    private Double precio;
    private int stock;

    public Catalogo() {}

     public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}