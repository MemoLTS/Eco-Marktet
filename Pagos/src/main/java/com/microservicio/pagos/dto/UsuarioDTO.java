package com.microservicio.pagos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

    @JsonProperty("id")
    private Long idusuario;

    private int rut;
    private String dv;
    private String nombre;
    private String email;
    private String contraseña;

    public UsuarioDTO() {
    }

    public Long getUsuarioId() {
        return idusuario;
    }

    public void setUsuarioId(Long idusuario) {
        this.idusuario = idusuario;
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