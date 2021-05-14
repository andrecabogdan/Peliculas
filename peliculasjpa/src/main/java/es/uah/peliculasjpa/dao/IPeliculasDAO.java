/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.peliculasjpa.dao;

import es.uah.peliculasjpa.model.Peliculas;

import java.util.List;

/**
 *
 * @author Bogdan
 */
public interface IPeliculasDAO {

    List<Peliculas> buscarTodos();

    Peliculas buscarPeliculasPorId(Integer idPelicula);

    List<Peliculas> buscarPeliculasPorTitulo(String titulo);

    List<Peliculas> buscarPeliculasPorGenero(String genero);

    void altaPelicula(Peliculas Pelicula);

    void bajaPelicula(Integer identificadorPelicula);

    void modificarPelicula(Peliculas Pelicula);
}
