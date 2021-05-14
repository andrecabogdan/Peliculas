/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.service;

import es.uah.peliculasjpa.model.Peliculas;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public interface IPeliculasService {

    List<Peliculas> buscarTodos();

    Peliculas buscarPeliculasPorId(Integer idPelicula);

    List<Peliculas> buscarPeliculasPorTitulo(String titulo);

    List<Peliculas> buscarPeliculasPorGenero(String genero);

    boolean altaPelicula(Peliculas pelicula);

    boolean bajaPelicula(Integer identificadorPelicula);

    void modificarPelicula(Peliculas pelicula);

}
