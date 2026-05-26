package com.caso3.tienda.service;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caso3.tienda.model.Tienda;
import com.caso3.tienda.repository.TiendaRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional

public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public Tienda crearTienda(Tienda tienda){
        tienda.setFechaCreacion(LocalDateTime.now());
        asignarEstado(tienda, true);
        return tiendaRepository.save(tienda);
    }

    public List<Tienda> listarTiendas(){
        return tiendaRepository.findAll();
    }

    public Tienda buscarTiendaPorId(Long idTienda){
        return tiendaRepository.findById(idTienda).orElse(null);
    }

    public Tienda modificarTienda(Long id, Tienda tienda){
        Tienda tiendaExistente = tiendaRepository.findById(id).orElse(null);
        if (tiendaExistente != null) {
            tiendaExistente.setNombre(tienda.getNombre());
            tiendaExistente.setDireccion(tienda.getDireccion());
            tiendaExistente.setTelefono(tienda.getTelefono());
            return tiendaRepository.save(tiendaExistente);
        } else {
            return null;
        }

    }

    public Tienda desactivarTienda(Long id){
        Tienda tiendaExistente = tiendaRepository.findById(id).orElse(null);
        if (tiendaExistente != null) {
            asignarEstado(tiendaExistente, false);
            return tiendaRepository.save(tiendaExistente);
        } else {
            return null;
        }
    }

    private void asignarEstado(Tienda tienda, boolean estado) {
        try {
            java.lang.reflect.Field field = Tienda.class.getDeclaredField("estado");
            field.setAccessible(true);
            field.set(tienda, estado);
        } catch (ReflectiveOperationException e) {
        }
    }

    public Tienda crearHorarioTienda(Long idTienda, Tienda tienda) {
        Tienda tiendaExistente = tiendaRepository.findById(idTienda)
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada con id: " + idTienda));
        if (tienda.getHoraApertura().isAfter(tienda.getHoraCierre())) {
            throw new RuntimeException("La hora de apertura no puede ser posterior a la hora de cierre");
        }
        tiendaExistente.setDiaSemana(tienda.getDiaSemana());
        tiendaExistente.setHoraApertura(tienda.getHoraApertura());
        tiendaExistente.setHoraCierre(tienda.getHoraCierre());
        return tiendaRepository.save(tiendaExistente);
    }

    public Tienda horarioTienda(Tienda tienda){
        Tienda tiendaExistente = tiendaRepository.findById(tienda.getIdTienda()).orElseThrow(() -> new RuntimeException("Tienda no encontrada"));
        
        LocalTime horaActual = LocalTime.now();

        boolean abierto = !horaActual.isBefore(tiendaExistente.getHoraApertura()) && !horaActual.isAfter(tiendaExistente.getHoraCierre());

        if (!abierto) {
            throw new RuntimeException("La tienda esta cerrada. Horario:" + tiendaExistente.getHoraApertura() + " - " + tiendaExistente.getHoraCierre());
        }
        return tiendaRepository.save(tiendaExistente);        
    }

    public void eliminarTienda(Long idTienda){
        tiendaRepository.deleteById(idTienda);
    }

    public List<Tienda> listarTiendasConHorarios() {
        return tiendaRepository.findAll();
    }

    public  List<Tienda> listarHorarioTienda(Long idTienda) {
        return tiendaRepository.findById(idTienda).map(List::of).orElse(List.of());
    }

    public Tienda modificarHorarioTienda(Long idTienda, Tienda tienda){
        Tienda existente = tiendaRepository.findById(idTienda).orElse(null);
        if (existente != null) {
            existente.setDiaSemana(tienda.getDiaSemana());
            existente.setHoraApertura(tienda.getHoraApertura());
            existente.setHoraCierre(tienda.getHoraCierre());
            return tiendaRepository.save(existente);
        } else {
            return null;
        }
    }

    public Tienda desactivarHorarioTienda(Long idTienda){
        Tienda existente = tiendaRepository.findById(idTienda).orElse(null);
        if (existente != null){
            existente.setEstado(false);
            return tiendaRepository.save(existente);
        }
        return null;
    }

    //Para eliminar un horario por el id
    public void eliminarHorarioTienda(Long idTienda){
        tiendaRepository.deleteById(idTienda);
    }

}
