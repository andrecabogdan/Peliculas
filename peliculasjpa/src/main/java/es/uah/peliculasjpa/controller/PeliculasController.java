/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import es.uah.peliculasjpa.model.Peliculas;
import es.uah.peliculasjpa.service.IPeliculasService;

/**
 *
 * @author Bogdan
 */
@RestController
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/peliculas")
    public List<Peliculas> buscarTodos() {
        return peliculasService.buscarTodos();
    }

    @GetMapping("/peliculas/{id}")
    public Peliculas buscarPeliculasPorId(@PathVariable("id") Integer id) {
        return peliculasService.buscarPeliculasPorId(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Peliculas> buscarPeliculaPorTítulo(@PathVariable("titulo") String titulo) {
        return peliculasService.buscarPeliculasPorTitulo(titulo);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Peliculas> buscarPeliculasPorGénero(@PathVariable("genero") String genero) {
        return peliculasService.buscarPeliculasPorGenero(genero);
    }

    @PostMapping(value = "/peliculas", produces = MediaType.TEXT_PLAIN_VALUE)
    public String altaPelicula(@RequestBody Peliculas pelicula) {
        return String.valueOf(peliculasService.altaPelicula(pelicula));
    }

    @DeleteMapping(value = "/peliculas/{identificador}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String bajaPelicula(@PathVariable("identificador") Integer identificador) {
        return String.valueOf(peliculasService.bajaPelicula(identificador));
    }

    @PutMapping("/peliculas")
    public void modificarPelicula(@RequestBody Peliculas pelicula) {
        peliculasService.modificarPelicula(pelicula);
    }

}
