package com.caso3.tienda.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tienda")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTienda;

    private String nombre;
    private String direccion;
    private String comuna;
    private String ciudad;
    private String region;
    private String telefono;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
    private String diaSemana;

    private LocalTime horaApertura = LocalTime.of(9, 0);
    private LocalTime horaCierre = LocalTime.of(21, 0);

    public Tienda() {
    }

    //Getters 
    public Long getIdTienda() {
        return idTienda;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public String getCiudad(){
        return ciudad;
    }

    public String getRegion(){
        return region;
    }

    public String getTelefono() {
        return telefono;
    }

    public Boolean getEstado() {
        return estado;
    }   

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    //Setters 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

}

