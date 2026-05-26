package com.caso3.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caso3.tienda.model.Tienda;
import com.caso3.tienda.service.TiendaService;

@RestController
@RequestMapping("api/v1/tienda")
@CrossOrigin(origins = "*")

public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    //Crear una nueva tienda
    @PostMapping("/crear")
    public Tienda crearTienda(@RequestBody Tienda tienda){
        return tiendaService.crearTienda(tienda);
    }

    //Listar las tiendas
    @GetMapping("/listar")
    public List <Tienda> listarTiendas(){
        return tiendaService.listarTiendas();
    }

    //Buscar tienda por id 
    @GetMapping("/buscar/{idTienda}")
    public Tienda buscarTiendaPorId(@PathVariable Long idTienda){
        return tiendaService.buscarTiendaPorId(idTienda);
    }

    //Modificar tienda
    @PutMapping("/modificar/{idTienda}")
    public Tienda modificarTienda(@PathVariable Long idTienda, @RequestBody Tienda tienda){
        return tiendaService.modificarTienda(idTienda, tienda);
    }

    //Desactivar tienda
    @PutMapping("/desactivar/{idTienda}")
    public Tienda desactivarTienda(@PathVariable Long idTienda){
        return tiendaService.desactivarTienda(idTienda);
    }

    //Eliminar tienda
    @DeleteMapping("/eliminar/{idTienda}")
    public void eliminarTienda(@PathVariable Long idTienda){
        tiendaService.eliminarTienda(idTienda);
    }

    //FUNCIONES DE HORARIOS

    //Crear horario de tienda
    @PostMapping("/crearHorario/{idTienda}")
    public Tienda crearHorarioTienda(@PathVariable Long idTienda, @RequestBody Tienda tienda){
            return tiendaService.crearHorarioTienda(idTienda, tienda);
        }

    //Listar todos los horarios
    @GetMapping("/listar/horarios")
    public List<Tienda> listarTiendasConHorarios(){
        return tiendaService.listarTiendasConHorarios();
    }

    //Listar horario por id de tienda
    @GetMapping("/listar/horarios/{idTienda}")
    public List<Tienda> listarHorarioTienda(@PathVariable Long idTienda){
        return tiendaService.listarHorarioTienda(idTienda);
    }

    //Modificar horario de tienda
    @PutMapping("/modificarHorarioTienda/{idTienda}")
    public Tienda modificarHorarioTienda(@PathVariable Long idTienda, @RequestBody Tienda tienda){
        return tiendaService.modificarHorarioTienda(idTienda, tienda);
    }

    //Desactivar horario de tienda
    @PutMapping("/desactivarHorario/{idTienda}")
    public Tienda desactivarHorarioTienda(@PathVariable Long idTienda){
        return tiendaService.desactivarHorarioTienda(idTienda);
    }

    //Eliminar horario de tienda
    @DeleteMapping("/eliminarHorario/{idTienda}")
    public void eliminarHorarioTienda(@PathVariable Long idTienda){
        tiendaService.eliminarHorarioTienda(idTienda);
    }

    //Faltan las otras clases
}
