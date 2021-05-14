/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.controller;

import es.uah.peliculasjpa.model.Actores;
import es.uah.peliculasjpa.service.IActoresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bogdan
 */
@RestController
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/actores")
    public List<Actores> buscarTodos() {
        return actoresService.buscarTodos();
    }

    @GetMapping("/actores/{identificador}")
    public Actores buscarActoresPorId(@PathVariable("identificador") Integer identificador) {
        return actoresService.buscarActoresPorId(identificador);
    }

    @GetMapping("/actores/nombre/{nombre}")
    public Actores buscarActoresPorNombre(@PathVariable("nombre") String nombre) {
        return actoresService.buscarActoresPorNombre(nombre);
    }

    @PostMapping("/actores")
    public void altaActor(@RequestBody Actores actor) {
        actoresService.altaActor(actor);
    }

    @DeleteMapping("/actores/{identificador}")
    public void bajaActor(@PathVariable("identificador") Integer identificador) {
        actoresService.bajaActor(identificador);
    }

    @PutMapping("/actores")
    public void modificarActor(@RequestBody Actores actor) {
        actoresService.modificarActor(actor);
    }
}
