package com.microservicio.facturacion.dto;


import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rut;


    private String dv;

    private String nombre;
    private String email;
    private String contraseña;

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }
        
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}